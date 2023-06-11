package de.planty;

public class MockData {

    //Mock data for Room
    public static final String ROOM_LIVINGROOM = "{\"name\": \"Living Room\", \"description\": \"The best room.\"}";
    public static final String ROOM_BEDROOM = "{\"name\": \"Bedroom\", \"description\": \"The sleepy room.\"}";

    //Mock data for PlantType
    public static final String PLANTTYPE_HERB = "{\"name\": \"Herb\", \"description\": \"The best plant type.\", \"minHumidityLevel\": 0}";

    //Mock data for Sensor
    public static final String SENSOR_1 = "{\"hardwareId\": \"1\", \"name\": \"Humidity\", \"description\": \"The best sensor.\", \"humidityScalingFrom\": 0, \"humidityScalingTo\": 100, \"lastCalibration\": \"2019-01-01T00:00:00.000Z\", \"sleepTimeout\": 1000}";

    //Mock data for Plant
    public static final String PLANT_BASIL = "{\"name\": \"Basil\", \"description\": \"The best plant.\", \"plantTypeId\": 1, \"sensorId\": 1, \"roomId\": 1}";
    public static final String PLANT_MINT = "{\"name\": \"Mint\", \"description\": \"The sleepy plant.\", \"plantTypeId\": 1, \"sensorId\": 1, \"roomId\": 2}"; 
}
