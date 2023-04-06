#!/bin/bash

# Stop backend container
docker container stop planty-backend

# Stop postgres container
docker container stop planty-database