#!/bin/bash

# Check if backend container already exists, then attach to it
if [[ ! -z $(docker ps -a | grep planty-backend) ]]
then
    docker attach planty-backend
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
if [[ -z $(docker network ls | grep planty) ]]
then
    docker network create planty
fi

# Start postgres database
docker run -d --rm --name planty-database --network planty -p 5432:5432 -v planty-database-volume:/var/lib/postgresql/data -e POSTGRES_USER=quarkus -e POSTGRES_PASSWORD="V%TFwzTBFx#tM9bLxx#&YTpY6!5g@d" -e POSTGRES_DB=planty postgres

# Build docker image
docker build -t planty-backend .

# Run backend inside container
docker run -itd --rm --name planty-backend --network planty -p 8080:8080 -v "$WD":/app -v "$HOME/.m2":/root/.m2 planty-backend mvn quarkus:dev
docker attach planty-backend