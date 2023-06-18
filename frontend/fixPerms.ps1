#!/bin/bash

# Check if user is in the frontend directory
WD=$(pwd)
if [[ ! "$WD" == *"/frontend" ]]
then
    echo "You must be inside the /frontend directory to run this script."
    exit
fi

# Fix node_modules
takeown /f node_modules /r /d
Get-ChildItem -Path .\node_modules -Recurse | ForEach-Object { $_.IsReadOnly = $false }
