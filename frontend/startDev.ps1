# Check if frontend container already exists, then attach to it
if((docker ps -a | Select-String "planty-frontend-dev")) {
    docker attach planty-frontend-dev;
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
if(-not (docker network ls | Select-String "planty-dev")) {
    docker network create planty-dev;
}

# Build docker image
docker build -t planty-frontend-dev -f dockerfile.dev .

# Run frontend inside container
docker run -itd --rm --name planty-frontend-dev --network planty-dev -p 4200:4200 -v ${WD}:/app planty-frontend-dev
docker attach planty-frontend-dev