$WD = Get-Location;
$WD = Convert-Path $WD;

# Check if user is in the backend directory
if(-not $WD.EndsWith("\backend")) {
    Write-Host "Please make sure you are in the backend directory" -ForegroundColor Red;
    exit;
}

# Build docker image
docker build -t planty-backend-dev -f dockerfile.dev .

# Overwrite container's default command: Compile backend inside container
docker run -it --rm --name planty-backend-compiler -v ${WD}:/app -v ${HOME}\.m2:/root/.m2 planty-backend-dev mvn clean install -DskipTests