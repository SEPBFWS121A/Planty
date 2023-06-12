package de.planty.api;

import de.planty.gen.api.SensorApi;
import de.planty.gen.model.GenSensor;
import de.planty.gen.model.GenSensorConfigurationPayload;
import de.planty.gen.model.GenSensorPayload;
import de.planty.hibernate.entity.EntitySensor;
import de.planty.hibernate.mapper.SensorEntityMapper;
import de.planty.util.ErrorResponseBuilder;
import de.planty.util.StringUtil;

import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.Date;
import java.util.List;

public class SensorApiImpl implements SensorApi {

    @Override
    public Response sensorGet() {
        List<GenSensor> genSensors = SensorEntityMapper.getInstance().mapAllPanacheEntities(EntitySensor.listAll());
        return Response
                .ok()
                .entity(genSensors)
                .build();
    }

    @Override
    public Response sensorByHardwareIdHardwareIdGet(String hardwareId) {
        EntitySensor entitySensor = EntitySensor.find("hardwareId", hardwareId).firstResult();
        if(entitySensor == null){
            return new ErrorResponseBuilder()
                    .setStatusCode(404)
                    .setMessage(String.format("No sensor found for hardwareId %s", hardwareId))
                    .build();
        }

        GenSensor genSensor = SensorEntityMapper.getInstance().mapPanacheEntity(entitySensor);
        return Response
                .ok()
                .entity(genSensor)
                .build();
    }

    @Override
    @Transactional
    public Response sensorPost(GenSensorPayload genSensorPayload) {
        if (StringUtil.isNullOrEmpty(genSensorPayload.getName())) {
            return new ErrorResponseBuilder()
                    .setMessage("name of a sensor must be set.")
                    .build();
        }

        if (StringUtil.isNullOrEmpty(genSensorPayload.getDescription())) {
            return new ErrorResponseBuilder()
                    .setMessage("description of a sensor must be set.")
                    .build();
        }

        if (StringUtil.isNullOrEmpty(genSensorPayload.getHardwareId())) {
            return new ErrorResponseBuilder()
                    .setMessage("hardwareId of a sensor must be set.")
                    .build();
        }

        EntitySensor entitySensor = SensorEntityMapper.getInstance().mapPayload(genSensorPayload);
        entitySensor.persist();
        return Response
                .created(URI.create(String.format("/sensor/%d", entitySensor.getId())))
                .build();
    }

    @Override
    @Transactional
    public Response sensorSensorIdDelete(String sensorId) {
        int id;
        try {
            id = Integer.parseInt(sensorId);
        } catch(NumberFormatException exception) {
            return new ErrorResponseBuilder()
                    .setMessage("sensorId could not be parsed to an integer value.")
                    .build();
        }

        EntitySensor entitySensor = EntitySensor.findById(id);
        if(entitySensor == null){
            return new ErrorResponseBuilder()
                    .setStatusCode(404)
                    .setMessage(String.format("No sensor found for plantId %s", sensorId))
                    .build();
        }

        entitySensor.delete();
        return Response
                .ok()
                .build();
    }

    @Override
    public Response sensorSensorIdGet(String sensorId) {
        int id;
        try {
            id = Integer.parseInt(sensorId);
        } catch(NumberFormatException exception) {
            return new ErrorResponseBuilder()
                    .setMessage("sensorId could not be parsed to an integer value.")
                    .build();
        }

        EntitySensor entitySensor = EntitySensor.findById(id);
        if(entitySensor == null) {
            return new ErrorResponseBuilder()
                    .setStatusCode(404)
                    .setMessage(String.format("No sensor found for sensorId %s", sensorId))
                    .build();
        }

        GenSensor genSensor = SensorEntityMapper.getInstance().mapPanacheEntity(entitySensor);
        return Response
                .ok()
                .entity(genSensor)
                .build();
    }

    @Override
    @Transactional
    public Response sensorSensorIdPut(String sensorId, GenSensorConfigurationPayload genSensorConfigurationPayload) {
        if (genSensorConfigurationPayload.getHumidityScalingFrom() == null) {
            return new ErrorResponseBuilder()
                    .setMessage("humidityScalingFrom of sensor configuration must be set.")
                    .build();
        }
        
        if (genSensorConfigurationPayload.getHumidityScalingTo() == null) {
            return new ErrorResponseBuilder()
                    .setMessage("humidityScalingTo of sensor configuration must be set.")
                    .build();
        }
        
        if(genSensorConfigurationPayload.getSleepTimeout() == null) {
            return new ErrorResponseBuilder()
                    .setMessage("sleepTimeout of sensor configuration must be set.")
                    .build();
        }

        int id;
        try {
            id = Integer.parseInt(sensorId);
        } catch(NumberFormatException exception) {
            return new ErrorResponseBuilder()
                    .setMessage("sensorId could not be parsed to an integer value.")
                    .build();
        }

        EntitySensor entitySensor = EntitySensor.findById(id);
        if (entitySensor == null) {
            return new ErrorResponseBuilder()
                    .setStatusCode(404)
                    .setMessage(String.format("No sensor found for sensorId %s", sensorId))
                    .build();
        }

        entitySensor.setHumidityScalingFrom(genSensorConfigurationPayload.getHumidityScalingFrom());
        entitySensor.setHumidityScalingTo(genSensorConfigurationPayload.getHumidityScalingTo());
        entitySensor.setSleepTimeout(genSensorConfigurationPayload.getSleepTimeout());
        entitySensor.setLastCalibration(new Date());
        return Response
                .ok()
                .build();
    }
}
