package de.planty.hibernate.mapper;

import de.planty.gen.model.GenPlant;
import de.planty.gen.model.GenPlantPayload;
import de.planty.hibernate.entity.EntityPlant;

public class PlantEntityMapper extends EntityMapperBase<EntityPlant, GenPlant, GenPlantPayload> {

    private static PlantEntityMapper plantEntityMapper;

    @Override
    public GenPlant mapPanacheEntity(EntityPlant panacheEntity) {
        GenPlant genPlant = new GenPlant();
        genPlant.setId(panacheEntity.getId());
        genPlant.setName(panacheEntity.getName());
        genPlant.setDescription(panacheEntity.getDescription());
        genPlant.setPlantTypeId(panacheEntity.getPlantTypeId());
        genPlant.setSensorId(panacheEntity.getSensorId());
        genPlant.setRoomId(panacheEntity.getRoomId());
        return genPlant;
    }

    @Override
    public EntityPlant mapGenEntity(GenPlant genEntity) {
        EntityPlant entityPlant = new EntityPlant();
        entityPlant.setId(genEntity.getId());
        entityPlant.setName(genEntity.getName());
        entityPlant.setDescription(genEntity.getDescription());
        entityPlant.setPlantTypeId(genEntity.getPlantTypeId());
        entityPlant.setSensorId(genEntity.getSensorId());
        entityPlant.setRoomId(genEntity.getRoomId());
        return entityPlant;
    }

    @Override
    public EntityPlant mapPayload(GenPlantPayload payload) {
        EntityPlant entityPlant = new EntityPlant();
        entityPlant.setName(payload.getName());
        entityPlant.setDescription(payload.getDescription());
        entityPlant.setPlantTypeId(payload.getPlantTypeId());
        entityPlant.setSensorId(payload.getSensorId());
        entityPlant.setRoomId(payload.getRoomId());
        return entityPlant;
    }

    public static PlantEntityMapper getInstance() {
        if (plantEntityMapper == null)
            plantEntityMapper = new PlantEntityMapper();
        return plantEntityMapper;
    }
}
