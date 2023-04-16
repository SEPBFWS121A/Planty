#!/bin/bash

# Check if backend container already exists, then attach to it
if [[ ! -z $(docker ps -a | grep planty-backend-dev) ]]
then
    docker attach planty-backend-dev
    exit
fi

# Check if user is in the backend directory
WD=$(pwd)
if [[ ! "$WD" == *"/backend" ]]
then
    echo "You must be inside the /backend directory to run this script."
    exit
fi

# Create planty docker network if it does not exist
if [[ -z $(docker network ls | grep planty-dev) ]]
then
    docker network create planty-dev
fi

# Start postgres database
docker run -d --rm --name planty-database-dev --network planty-dev -p 5432:5432 -e POSTGRES_USER=quarkus -e POSTGRES_PASSWORD="V%TFwzTBFx#tM9bLxx#&YTpY6!5g@d" -e POSTGRES_DB=planty postgres

# Build docker image
docker build -t planty-backend-dev -f dockerfile.dev .

# Run backend inside container
docker run -itd --rm --name planty-backend-dev --network planty-dev -p 8080:8080 -v "$WD":/app -v "$HOME/.m2":/root/.m2 planty-backend-dev
docker attach planty-backend-dev