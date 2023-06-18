package de.planty.hibernate.mapper;

import de.planty.gen.model.GenPlantType;
import de.planty.gen.model.GenPlantTypePayload;
import de.planty.hibernate.entity.EntityPlantType;

public class PlantTypeEntityMapper extends EntityMapperBase<EntityPlantType, GenPlantType, GenPlantTypePayload> {

    private static PlantTypeEntityMapper plantTypeEntityMapper;

    @Override
    public GenPlantType mapPanacheEntity(EntityPlantType panacheEntity) {
        GenPlantType genPlantType = new GenPlantType();
        genPlantType.setId(panacheEntity.getId());
        genPlantType.setName(panacheEntity.getName());
        genPlantType.setDescription(panacheEntity.getDescription());
        genPlantType.setMinHumidityLevel(panacheEntity.getMinHumidityLevel());
        return genPlantType;
    }

    @Override
    public EntityPlantType mapGenEntity(GenPlantType genEntity) {
        EntityPlantType entityPlantType = new EntityPlantType();
        entityPlantType.setId(genEntity.getId());
        entityPlantType.setName(genEntity.getName());
        entityPlantType.setDescription(genEntity.getDescription());
        entityPlantType.setMinHumidityLevel(genEntity.getMinHumidityLevel());
        return entityPlantType;
    }

    @Override
    public EntityPlantType mapPayload(GenPlantTypePayload payload) {
        EntityPlantType entityPlantType = new EntityPlantType();
        entityPlantType.setName(payload.getName());
        entityPlantType.setDescription(payload.getDescription());
        entityPlantType.setMinHumidityLevel(payload.getMinHumidityLevel());
        return entityPlantType;
    }

    public static PlantTypeEntityMapper getInstance() {
        if (plantTypeEntityMapper == null)
            plantTypeEntityMapper = new PlantTypeEntityMapper();
        return plantTypeEntityMapper;
    }
}
