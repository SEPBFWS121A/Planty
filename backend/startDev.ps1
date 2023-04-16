# Check if backend container already exists, then attach to it
if((docker ps -a | Select-String "planty-backend-dev")) {
    docker attach planty-backend-dev;
    exit;
}

$WD = Get-Location;
$WD = Convert-Path $WD;

# Check if user is in the backend directory
if(-not $WD.EndsWith("\backend")) {
    Write-Host "Please make sure you are in the backend directory" -ForegroundColor Red;
    exit;
}

# Create planty docker network if it does not exist
if(-not (docker network ls | Select-String "planty-dev")) {
    docker network create planty-dev;
}

# Start postgres database
docker run -d --rm --name planty-database-dev --network planty-dev -p 5432:5432 -e POSTGRES_USER=quarkus -e POSTGRES_PASSWORD="V%TFwzTBFx#tM9bLxx#&YTpY6!5g@d" -e POSTGRES_DB=planty postgres

# Build docker image
docker build -t planty-backend-dev -f dockerfile.dev .

# Run backend inside container
docker run -itd --rm --name planty-backend-dev --network planty-dev -p 8080:8080 -v ${WD}:/app -v ${HOME}\.m2:/root/.m2 planty-backend-dev
docker attach planty-backend-dev