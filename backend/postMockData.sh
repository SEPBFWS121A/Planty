#!/bin/bash

# Rooms
curl -v -X POST -H "Content-Type: application/json" -d '{"name": "Living Room", "description": "The best room."}' http://localhost:8080/room
curl -v -X POST -H "Content-Type: application/json" -d '{"name": "Bedroom", "description": "The sleepy room."}' http://localhost:8080/room

# Plant Types
curl -v -X POST -H "Content-Type: application/json" -d '{"name": "Sunflower", "description": "Draws energy during the day, but loses energy at night. +5 Energy/minute at day, -3.25 Energy/minute at night."}' http://localhost:8080/plantType
curl -v -X POST -H "Content-Type: application/json" -d '{"name": "Tulip", "description": "A family of flowers that originated from Turkey."}' http://localhost:8080/plantType

# Sensor
curl -v -X POST -H "Content-Type: application/json" -d '{"name": "Epic Sensor", "description": "The most accurate of them all. This is the main character."}' http://localhost:8080/sensor
curl -v -X POST -H "Content-Type: application/json" -d '{"name": "Crippled Sensor", "description": "This one has cheap parts built into it."}' http://localhost:8080/sensor

curl -v -X PUT -H "Content-Type: application/json" -d '{"humidityScalingFrom": 0, "humidityScalingTo": 100, "sleepTimeout": 60}' http://localhost:8080/sensor/5
curl -v -X PUT -H "Content-Type: application/json" -d '{"humidityScalingFrom": 32, "humidityScalingTo": 65, "sleepTimeout": 60}' http://localhost:8080/sensor/6

# Plant
curl -v -X POST -H "Content-Type: application/json" -d '{"name": "Betty", "description": "Betty was your first sunflower. By the help of Planty, you managed to keep her alive ever since.", "plantTypeId": 1, "sensorId": 1, "roomId": 1}' http://localhost:8080/plant
curl -v -X POST -H "Content-Type: application/json" -d '{"name": "Cassandra", "description": "Cassandra is a proud tulip.", "plantTypeId": 2, "sensorId": 2, "roomId": 2}' http://localhost:8080/plant

# Moisture Records
for m in 01 02 03 04 05 06 07 08 09 10 11 12
do
  for d in {10..28}
  do
    curl -v -X POST -H "Content-Type: application/json" -d '{"timestamp": "2021-'$m'-'$d'T12:00:00Z", "humidityLevel": '$(($RANDOM % 100))', "plantId": 7}' http://localhost:8080/moistureRecord
    curl -v -X POST -H "Content-Type: application/json" -d '{"timestamp": "2021-'$m'-'$d'T12:00:00Z", "humidityLevel": '$(($RANDOM % 33 + 32))', "plantId": 8}' http://localhost:8080/moistureRecord
  done
done
echo "Posted 2 rooms, plant types, sensors, plants and a lot of moisture records to localhost:8080."
