# Make sure user is in frontend directory
$WD = Get-Location;
$WD = Convert-Path $WD;

# If $WD ends with "frontend"
if(-not $WD.EndsWith("\frontend")) {
    Write-Host "Please make sure you are in the frontend directory" -ForegroundColor Red;
    exit;
}

# Build docker image
docker build -t planty-frontend-dev -f dockerfile.dev .

# Run yarn install inside container
docker run -it --rm --name planty-frontend-compiler -v ${WD}:/app planty-frontend-dev yarn install

# Run frontend inside container
docker run -it --rm --name planty-frontend-compiler -v ${WD}:/app planty-frontend-dev ng build