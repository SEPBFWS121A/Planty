# Check if frontend container already exists, then attach to it
if((docker ps -a | Select-String "planty-frontend")) {
    docker attach planty-frontend;
    exit;
}

$WD = Get-Location;
$WD = Convert-Path $WD;

# Check if user is in the frontend directory
if(-not $WD.EndsWith("\frontend")) {
    Write-Host "Please make sure you are in the frontend directory" -ForegroundColor Red;
    exit;
}

# Create planty docker network if it does not exist
if(-not (docker network ls | Select-String "planty")) {
    docker network create planty;
}

# Build docker image
docker build -t planty-frontend .

# Run yarn install inside container
docker run -it --rm --name planty-frontend -v ${WD}:/app planty-frontend yarn install

# Run frontend inside container
docker run -itd --rm --name planty-frontend --network planty -p 4200:4200 -v ${WD}:/app planty-frontend ng serve --poll 2000 --disable-host-check --host 0.0.0.0
docker attach planty-frontend