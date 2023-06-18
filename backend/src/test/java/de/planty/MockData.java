package de.planty;

public class MockData {

    // Mock data for Room
    public static final String ROOM_LIVINGROOM = "{\"name\": \"Living Room\", \"description\": \"The best room.\"}";
    public static final String ROOM_BEDROOM = "{\"name\": \"Bedroom\", \"description\": \"The sleepy room.\"}";

    // Mock data for PlantType
    public static final String PLANTTYPE_HERB = "{\"name\": \"Herb\", \"description\": \"The best plant type.\", \"minHumidityLevel\": 0}";
    public static final String PLANTTYPE_CACTUS = "{\"name\": \"Cactus\", \"description\": \"The sleepy plant type.\", \"minHumidityLevel\": 0}";

    // Mock data for Sensor
    public static final String SENSOR_1 = "{\"hardwareId\": \"1\", \"name\": \"Humidity\", \"description\": \"The best sensor.\", \"humidityScalingFrom\": 0, \"humidityScalingTo\": 100, \"lastCalibration\": \"2019-01-01T00:00:00.000Z\", \"sleepTimeout\": 1000}";
    public static final String SENSOR_2 = "{\"hardwareId\": \"2\", \"name\": \"Temperature\", \"description\": \"The best sensor.\", \"humidityScalingFrom\": 0, \"humidityScalingTo\": 100, \"lastCalibration\": \"2019-01-01T00:00:00.000Z\", \"sleepTimeout\": 1000}";
    public static final String SENSOR_1_UPDATE = "{\"humidityScalingFrom\": 10, \"humidityScalingTo\": 95, \"sleepTimeout\": 2000}";
    public static final String SENSOR_2_UPDATE = "{\"humidityScalingFrom\": 0, \"humidityScalingTo\": 90, \"sleepTimeout\": 1000}";

    // Mock data for Plant
    public static final String PLANT_BASIL = "{\"name\":\"Basil\",\"description\":\"The best plant.\",\"plantTypeId\":7,\"sensorId\":11,\"roomId\":9}";
    public static final String PLANT_MINT = "{\"name\":\"Mint\",\"description\":\"The sleepy plant.\",\"plantTypeId\":7,\"sensorId\":12,\"roomId\":10}";
}
