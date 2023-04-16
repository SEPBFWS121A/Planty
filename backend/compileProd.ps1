$WD = Get-Location;
$WD = Convert-Path $WD;

# Check if user is in the backend directory
if(-not $WD.EndsWith("\backend")) {
    Write-Host "Please make sure you are in the backend directory" -ForegroundColor Red;
    exit;
}

# Build docker image
docker build -t planty-backend-prod -f dockerfile .