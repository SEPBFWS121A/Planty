#!/bin/bash

# Check if user is in the frontend directory
WD=$(pwd)
if [[ ! "$WD" == *"/frontend" ]]
then
    echo "You must be inside the /frontend directory to run this script."
    exit
fi

# Fix permissions
./fixPerms.sh

# Open cypress
yarn cypress run
