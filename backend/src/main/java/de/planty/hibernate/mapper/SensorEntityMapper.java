package de.planty.hibernate.mapper;

import de.planty.gen.model.GenSensor;
import de.planty.gen.model.GenSensorPayload;
import de.planty.hibernate.entity.EntitySensor;

import java.util.Date;

public class SensorEntityMapper extends EntityMapperBase<EntitySensor, GenSensor, GenSensorPayload> {

    private static SensorEntityMapper sensorEntityMapper;

    @Override
    public GenSensor mapPanacheEntity(EntitySensor panacheEntity) {
        GenSensor genSensor = new GenSensor();
        genSensor.setId(panacheEntity.getId());
        genSensor.setHardwareId(panacheEntity.getHardwareId());
        genSensor.setName(panacheEntity.getName());
        genSensor.setDescription(panacheEntity.getDescription());
        genSensor.setHumidityScalingFrom(panacheEntity.getHumidityScalingFrom());
        genSensor.setHumidityScalingTo(panacheEntity.getHumidityScalingTo());
        genSensor.setLastCalibration(panacheEntity.getLastCalibration());
        genSensor.setSleepTimeout(panacheEntity.getSleepTimeout());
        return genSensor;
    }

    @Override
    public EntitySensor mapGenEntity(GenSensor genEntity) {
        EntitySensor entitySensor = new EntitySensor();
        entitySensor.setHardwareId(genEntity.getHardwareId());
        entitySensor.setName(genEntity.getName());
        entitySensor.setDescription(genEntity.getDescription());
        entitySensor.setHumidityScalingFrom(genEntity.getHumidityScalingFrom());
        entitySensor.setHumidityScalingTo(genEntity.getHumidityScalingTo());
        entitySensor.setLastCalibration(genEntity.getLastCalibration());
        entitySensor.setSleepTimeout(genEntity.getSleepTimeout());
        return entitySensor;
    }

    @Override
    public EntitySensor mapPayload(GenSensorPayload payload) {
        EntitySensor entitySensor = new EntitySensor();
        entitySensor.setHardwareId(payload.getHardwareId());
        entitySensor.setName(payload.getName());
        entitySensor.setDescription(payload.getDescription());
        entitySensor.setHumidityScalingFrom(0);
        entitySensor.setHumidityScalingTo(100);
        entitySensor.setLastCalibration(new Date(0));
        entitySensor.setSleepTimeout(60);
        return entitySensor;
    }

    public static SensorEntityMapper getInstance() {
        if(sensorEntityMapper == null)
            sensorEntityMapper = new SensorEntityMapper();
        return sensorEntityMapper;
    }
}
