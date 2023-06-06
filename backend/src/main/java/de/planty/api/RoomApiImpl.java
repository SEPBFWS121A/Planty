package de.planty.api;

import de.planty.gen.api.RoomApi;
import de.planty.gen.model.GenRoom;
import de.planty.gen.model.GenRoomPayload;
import de.planty.hibernate.entity.EntityRoom;
import de.planty.hibernate.mapper.RoomEntityMapper;
import de.planty.util.ErrorResponseBuilder;

import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

public class RoomApiImpl implements RoomApi {

    @Override
    public Response roomGet() {
        List<GenRoom> genRooms = RoomEntityMapper.getInstance().mapAllPanacheEntities(EntityRoom.listAll());
        return Response
                .ok()
                .entity(genRooms)
                .build();
    }

    @Override
    @Transactional
    public Response roomPost(GenRoomPayload genRoomPayload) {
        if (genRoomPayload.getName() == null) {
            return new ErrorResponseBuilder()
                    .setMessage("name of room must be set.")
                    .build();
        }
        
        if(genRoomPayload.getDescription() == null) {
            return new ErrorResponseBuilder()
                    .setMessage("description of room must be set.")
                    .build();
        }

        EntityRoom entityRoom = RoomEntityMapper.getInstance().mapPayload(genRoomPayload);
        entityRoom.persist();
        return Response
                .created(URI.create(String.format("/room/%d", entityRoom.getId())))
                .build();
    }

    @Override
    public Response roomRoomIdDelete(String roomId) {
        int id;
        try {
            id = Integer.parseInt(roomId);
        } catch(NumberFormatException exception) {
            return new ErrorResponseBuilder()
                    .setMessage("roomId could not be parsed to an integer value.")
                    .build();
        }

        EntityRoom entityRoom = EntityRoom.findById(id);
        if (entityRoom == null) {
            return new ErrorResponseBuilder()
                    .setStatusCode(404)
                    .setMessage(String.format("No room found for roomId %s", roomId))
                    .build();
        }

        entityRoom.delete();
        return Response
                .ok()
                .build();
    }

    @Override
    public Response roomRoomIdGet(String roomId) {
        int id;
        try {
            id = Integer.parseInt(roomId);
        } catch(NumberFormatException exception) {
            return new ErrorResponseBuilder()
                    .setMessage("roomId could not be parsed to an integer value.")
                    .build();
        }

        EntityRoom entityRoom = EntityRoom.findById(id);
        if (entityRoom == null) {
            return new ErrorResponseBuilder()
                    .setStatusCode(404)
                    .setMessage(String.format("No room found for roomId %s", roomId))
                    .build();
        }

        GenRoom genRoom = RoomEntityMapper.getInstance().mapPanacheEntity(entityRoom);
        return Response
                .ok()
                .entity(genRoom)
                .build();
    }
}
