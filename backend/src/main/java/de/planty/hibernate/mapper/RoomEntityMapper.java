package de.planty.hibernate.mapper;

import de.planty.gen.model.GenRoom;
import de.planty.gen.model.GenRoomPayload;
import de.planty.hibernate.entity.EntityRoom;

public class RoomEntityMapper extends EntityMapperBase<EntityRoom, GenRoom, GenRoomPayload> {

    private static RoomEntityMapper roomEntityMapper;

    @Override
    public GenRoom mapPanacheEntity(EntityRoom panacheEntity) {
        GenRoom genRoom = new GenRoom();
        genRoom.setId(panacheEntity.getId());
        genRoom.setName(panacheEntity.getName());
        genRoom.setDescription(panacheEntity.getDescription());
        return genRoom;
    }

    @Override
    public EntityRoom mapGenEntity(GenRoom genEntity) {
        EntityRoom entityRoom = new EntityRoom();
        entityRoom.setId(genEntity.getId());
        entityRoom.setName(genEntity.getName());
        entityRoom.setDescription(genEntity.getDescription());
        return entityRoom;
    }

    @Override
    public EntityRoom mapPayload(GenRoomPayload payload) {
        EntityRoom entityRoom = new EntityRoom();
        entityRoom.setName(payload.getName());
        entityRoom.setDescription(payload.getDescription());
        return entityRoom;
    }

    public static RoomEntityMapper getInstance() {
        if (roomEntityMapper == null)
            roomEntityMapper = new RoomEntityMapper();
        return roomEntityMapper;
    }
}
