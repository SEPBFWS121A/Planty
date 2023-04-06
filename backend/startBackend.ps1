# Check if backend container already exists, then attach to it
if((docker ps -a | Select-String "planty-backend")) {
    docker attach planty-backend;
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
if(-not (docker network ls | Select-String "planty")) {
    docker network create planty;
}

# Start postgres database
docker run -d --rm --name planty-database --network planty -p 5432:5432 -v planty-database-volume:/var/lib/postgresql/data -e POSTGRES_USER=quarkus -e POSTGRES_PASSWORD="V%TFwzTBFx#tM9bLxx#&YTpY6!5g@d" -e POSTGRES_DB=planty postgres

# Build docker image
docker build -t planty-backend .

# Run backend inside container
docker run -itd --rm --name planty-backend --network planty -p 8080:8080 -v ${WD}:/app -v ${HOME}\.m2:/root/.m2 planty-backend mvn quarkus:dev
docker attach planty-backend