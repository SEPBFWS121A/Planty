#!/bin/bash

# Check if user is in the backend directory
WD=$(pwd)
if [[ ! "$WD" == *"/backend" ]]
then
    echo "You must be inside the /backend directory to run this script."
    exit
fi

# Build docker image
docker build -t planty-backend .

# Compile backend inside container
docker run -it --rm --name planty-backend-compiler -v "$WD":/app -v "$HOME/.m2":/root/.m2 planty-backend mvn clean quarkus:build
