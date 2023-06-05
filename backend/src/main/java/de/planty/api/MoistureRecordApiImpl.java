package de.planty.api;

import de.planty.gen.api.MoistureRecordApi;
import de.planty.gen.model.GenMoistureRecord;
import de.planty.gen.model.GenMoistureRecordPayload;
import de.planty.hibernate.entity.EntityMoistureRecord;
import de.planty.hibernate.mapper.MoistureRecordEntityMapper;
import de.planty.util.ErrorResponseBuilder;

import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.Date;
import java.util.List;

public class MoistureRecordApiImpl implements MoistureRecordApi {

    @Override
    public Response moistureRecordGet() {
        List<GenMoistureRecord> genMoistureRecords = MoistureRecordEntityMapper.getInstance().mapAllPanacheEntities(EntityMoistureRecord.listAll());
        return Response
                .ok()
                .entity(genMoistureRecords)
                .build();
    }

    @Override
    @Transactional
    public Response moistureRecordMoistureRecordIdDelete(String moistureRecordId) {
        int id;
        try {
            id = Integer.parseInt(moistureRecordId);
        } catch(NumberFormatException exception) {
            return new ErrorResponseBuilder()
                    .setMessage("moistureRecordId could not be parsed to an integer value.")
                    .build();
        }

        EntityMoistureRecord entityMoistureRecord = EntityMoistureRecord.findById(id);
        if(entityMoistureRecord == null) {
            return new ErrorResponseBuilder()
                    .setStatusCode(404)
                    .setMessage(String.format("No moisture record found for moistureRecordId %s", moistureRecordId))
                    .build();
        }

        entityMoistureRecord.delete();
        return Response
                .ok()
                .build();
    }

    @Override
    public Response moistureRecordMoistureRecordIdGet(String moistureRecordId) {
        int id;
        try {
            id = Integer.parseInt(moistureRecordId);
        } catch(NumberFormatException exception) {
            return new ErrorResponseBuilder()
                    .setMessage("moistureRecordId could not be parsed to an integer value.")
                    .build();
        }

        EntityMoistureRecord entityMoistureRecord = EntityMoistureRecord.findById(id);
        if(entityMoistureRecord == null) {
            return new ErrorResponseBuilder()
                    .setStatusCode(404)
                    .setMessage(String.format("No moisture record found for moistureRecordId %s", moistureRecordId))
                    .build();
        }

        GenMoistureRecord genMoistureRecord = MoistureRecordEntityMapper.getInstance().mapPanacheEntity(entityMoistureRecord);
        return Response
                .ok()
                .entity(genMoistureRecord)
                .build();
    }

    @Override
    @Transactional
    public Response moistureRecordPost(GenMoistureRecordPayload genMoistureRecordPayload) {
        if(genMoistureRecordPayload.getHumidityLevel() == null) {
            return new ErrorResponseBuilder()
                    .setMessage("humidityLevel of moisture record must be set.")
                    .build();
        }
        
        if (genMoistureRecordPayload.getPlantId() == null) {
            return new ErrorResponseBuilder()
                    .setMessage("plantId of moisture record must be set.")
                    .build();
        }

        if (genMoistureRecordPayload.getTimestamp() == null) {
            genMoistureRecordPayload.setTimestamp(new Date());
        }

        EntityMoistureRecord entityMoistureRecord = MoistureRecordEntityMapper.getInstance().mapPayload(genMoistureRecordPayload);
        entityMoistureRecord.persist();
        return Response
                .created(URI.create(String.format("/moistureRecord/%d", entityMoistureRecord.getId())))
                .build();
    }

    @Override
    public Response moistureRecordByPlantPlantIdGet(String plantId) {
        int id;
        try {
            id = Integer.parseInt(plantId);
        } catch(NumberFormatException exception) {
            return new ErrorResponseBuilder()
                    .setMessage("plantId could not be parsed to an integer value.")
                    .build();
        }

        List<GenMoistureRecord> genMoistureRecords = MoistureRecordEntityMapper.getInstance().mapAllPanacheEntities(EntityMoistureRecord.list("plantId", id));
        return Response
                .ok()
                .entity(genMoistureRecords)
                .build();
    }
}
