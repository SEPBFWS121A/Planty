#!/bin/bash

# Stop backend container
docker container stop planty-backend-dev

# Stop postgres container
docker container stop planty-database-dev