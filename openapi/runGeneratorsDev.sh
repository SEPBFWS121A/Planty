#!/bin/bash

# Checks
WD=$(pwd)
if [[ ! "$WD" == *"/openapi" ]]
then
    echo "You must be inside the /openapi directory to run this script."
    exit
fi

# Set server variables
PROTOCOL=http
HOST=localhost
PORT=8080
BASE_PATH=""

# Setup
mkdir -p ./bin
curl https://raw.githubusercontent.com/OpenAPITools/openapi-generator/master/bin/utils/openapi-generator-cli.sh > ./bin/openapi-generator.sh
chmod u+x ./bin/openapi-generator.sh

# Cleanup
rm -rf ./.backend/* ./.frontend/*
mkdir -p ./.backend ./.frontend

# Generating backend
echo '{ "hideGenerationTimestamp": true, "interfaceOnly": true, "useSwaggerAnnotations": false, "returnResponse": true }"' > ./config.json
bin/openapi-generator.sh generate -i openapi.yaml -g jaxrs-spec --package-name "de.planty.gen" --api-package "de.planty.gen.api" --model-package "de.planty.gen.model" --model-name-prefix "Gen" --server-variables protocol="$PROTOCOL",host="$HOST",port="$PORT",basePath="$BASE_PATH" -c ./config.json -o ./.backend
rm ./config.json

# Generating frontend
bin/openapi-generator.sh generate -i openapi.yaml -g typescript-angular --type-mappings "DateTime=Date" --server-variables protocol="$PROTOCOL",host="$HOST",port="$PORT",basePath="$BASE_PATH" -o ./.frontend

# Copying to backend
rm -rf ../backend/src/main/java/de/planty/gen
mkdir -p ../backend/src/main/java/de/planty/gen
cp -r ./.backend/src/gen/java/de/planty/gen/* ../backend/src/main/java/de/planty/gen

# Copying to frontend
rm -rf ../frontend/src/assets/ts-api-client
mkdir -p ../frontend/src/assets/ts-api-client
cp ./.frontend/*.ts ../frontend/src/assets/ts-api-client
cp -r ./.frontend/api ../frontend/src/assets/ts-api-client
cp -r ./.frontend/model ../frontend/src/assets/ts-api-client

# Cleanup
rm -rf ./.backend ./.frontend
