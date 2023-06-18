# Make sure user is in frontend directory
$WD = Get-Location;
$WD = Convert-Path $WD;

# If $WD ends with "frontend"
if(-not $WD.EndsWith("\frontend")) {
    Write-Host "Please make sure you are in the frontend directory" -ForegroundColor Red;
    exit;
}

# Run cypress
yarn cypress open
