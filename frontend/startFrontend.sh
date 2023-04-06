#!/bin/bash

# Check if frontend container already exists, then attach to it
if [[ ! -z $(docker ps -a | grep planty-frontend) ]]
then
    docker attach planty-frontend
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
if [[ -z $(docker network ls | grep planty) ]]
then
    docker network create planty
fi

# Build docker image
docker build -t planty-frontend .

# Run yarn install inside container
docker run -it --rm --name planty-frontend -v "$WD":/app planty-frontend yarn install

# Run frontend inside container
docker run -itd --rm --name planty-frontend --network planty -p 4200:4200 -v "$WD":/app planty-frontend ng serve --poll 2000 --disable-host-check --host 0.0.0.0
docker attach planty-frontend
