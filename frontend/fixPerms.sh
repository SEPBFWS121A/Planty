#!/bin/bash

# Check if user is in the frontend directory
WD=$(pwd)
if [[ ! "$WD" == *"/frontend" ]]
then
    echo "You must be inside the /frontend directory to run this script."
    exit
fi

# Fix .sh files
sudo chmod +x ./*.sh

# Fix node_modules
USER=$(whoami)
GROUP=$(groups | awk '{print $1}')
sudo chown $USER:$GROUP -R ./node_modules
sudo chmod u+rw -R ./node_modules
