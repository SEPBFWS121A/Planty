package de.planty.api;

import de.planty.gen.api.PlantApi;
import de.planty.gen.model.GenPlant;
import de.planty.gen.model.GenPlantPayload;
import de.planty.hibernate.entity.EntityPlant;
import de.planty.hibernate.entity.EntityPlantType;
import de.planty.hibernate.entity.EntityRoom;
import de.planty.hibernate.entity.EntitySensor;
import de.planty.hibernate.mapper.PlantEntityMapper;
import de.planty.util.ErrorResponseBuilder;
import de.planty.util.StringUtil;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

public class PlantApiImpl implements PlantApi {

    @Override
    public Response plantGet() {
        List<GenPlant> genPlants = PlantEntityMapper.getInstance().mapAllPanacheEntities(EntityPlant.listAll());
        return Response
                .ok()
                .entity(genPlants)
                .build();
    }

    @Override
    @Transactional
    public Response plantPlantIdDelete(String plantId) {
        int id;
        try {
            id = Integer.parseInt(plantId);
        } catch(NumberFormatException exception) {
            return new ErrorResponseBuilder()
                    .setMessage("plantId could not be parsed to an integer value.")
                    .build();
        }

        EntityPlant entityPlant = EntityPlant.findById(id);
        if (entityPlant == null) {
            return new ErrorResponseBuilder()
                    .setStatusCode(404)
                    .setMessage(String.format("No plant found for plantId %s", plantId))
                    .build();
        }

        entityPlant.delete();
        return Response
                .ok()
                .build();
    }

    @Override
    public Response plantPlantIdGet(String plantId) {
        int id;
        try {
            id = Integer.parseInt(plantId);
        } catch(NumberFormatException exception) {
            return new ErrorResponseBuilder()
                    .setMessage("plantId could not be parsed to an integer value.")
                    .build();
        }

        EntityPlant entityPlant = EntityPlant.findById(id);
        if (entityPlant == null) {
            return new ErrorResponseBuilder()
                    .setStatusCode(404)
                    .setMessage(String.format("No plant found for plantId %s", plantId))
                    .build();
        }

        GenPlant genPlant = PlantEntityMapper.getInstance().mapPanacheEntity(entityPlant);
        return Response
                .ok()
                .entity(genPlant)
                .build();
    }

    @Override
    @Transactional
    public Response plantPost(GenPlantPayload genPlantPayload) {
        if (StringUtil.isNullOrEmpty(genPlantPayload.getName())) {
            return new ErrorResponseBuilder()
                    .setMessage("name of a plant must be set.")
                    .build();
        }

        if(StringUtil.isNullOrEmpty(genPlantPayload.getDescription())){
            return new ErrorResponseBuilder()
                    .setMessage("description of a plant must be set.")
                    .build();
        }
        
        if (genPlantPayload.getPlantTypeId() == null) {
            return new ErrorResponseBuilder()
                    .setMessage("plantTypeId of a plant must be set.")
                    .build();
        }

        // roomId is considered obsolete
        /*
        if (genPlantPayload.getRoomId() == null) {
            return new ErrorResponseBuilder()
                    .setMessage("roomId of a plant must be set.")
                    .build();
        }
        */

        if (genPlantPayload.getSensorId() == null) {
            return new ErrorResponseBuilder()
                    .setMessage("sensorId of a plant must be set.")
                    .build();
        }

        EntityRoom entityRoom = EntityRoom.findById(genPlantPayload.getRoomId());
        if (entityRoom == null) {
            return new ErrorResponseBuilder()
                    .setStatusCode(404)
                    .setMessage(String.format("No room found for roomId %d", genPlantPayload.getRoomId()))
                    .build();
        }

        EntityPlantType entityPlantType = EntityPlantType.findById(genPlantPayload.getPlantTypeId());
        if (entityPlantType == null) {
            return new ErrorResponseBuilder()
                    .setStatusCode(404)
                    .setMessage(String.format("No plantType found for plantTypeId %d", genPlantPayload.getPlantTypeId()))
                    .build();
        }

        EntitySensor entitySensor = EntitySensor.findById(genPlantPayload.getSensorId());
        if (entitySensor == null) {
            return new ErrorResponseBuilder()
                    .setStatusCode(404)
                    .setMessage(String.format("No sensor found for sensorId %d", genPlantPayload.getSensorId()))
                    .build();
        }

        EntityPlant entityPlant = PlantEntityMapper.getInstance().mapPayload(genPlantPayload);
        entityPlant.persist();
        return Response
                .created(URI.create(String.format("/plant/%d", entityPlant.getId())))
                .build();
    }
}
