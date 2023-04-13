#!/bin/bash

# Check if frontend container already exists, then attach to it
if [[ ! -z $(docker ps -a | grep planty-frontend-dev) ]]
then
    docker attach planty-frontend-dev
    exit
fi

# Check if user is in the frontend directory
WD=$(pwd)
if [[ ! "$WD" == *"/frontend" ]]
then
    echo "You must be inside the /frontend directory to run this script."
    exit
fi

# Create planty docker network if it does not exist
if [[ -z $(docker network ls | grep planty-dev) ]]
then
    docker network create planty-dev
fi

# Build docker image
docker build -t planty-frontend-dev -f dockerfile.dev .

# Run frontend inside container
docker run -itd --rm --name planty-frontend-dev --network planty-dev -p 4200:4200 -v "$WD":/app planty-frontend-dev
docker attach planty-frontend-dev
