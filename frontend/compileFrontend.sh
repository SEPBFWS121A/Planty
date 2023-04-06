#!/bin/bash

# Check if user is in the frontend directory
WD=$(pwd)
if [[ ! "$WD" == *"/frontend" ]]
then
    echo "You must be inside the /frontend directory to run this script."
    exit
fi

# Build docker image
docker build -t planty-frontend .

# Run yarn install inside container
docker run -it --rm --name planty-frontend-compiler -v $WD:/app planty-frontend yarn install

# Run frontend inside container
docker run -it --rm --name planty-frontend-compiler -v $WD:/app planty-frontend ng build