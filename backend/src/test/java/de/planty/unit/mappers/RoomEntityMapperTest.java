package de.planty.unit.mappers;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import de.planty.gen.model.GenRoom;
import de.planty.gen.model.GenRoomPayload;
import de.planty.hibernate.entity.EntityRoom;
import de.planty.hibernate.mapper.RoomEntityMapper;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RoomEntityMapperTest {

    @Test
    public void testRoomEntityMapperPanacheEntityToGenEntity() {
        EntityRoom entityRoom = new EntityRoom();
        entityRoom.setId(0);
        entityRoom.setName("Backroom");
        entityRoom.setDescription("Once entered, one never leaves again");

        GenRoom genRoomPayload = RoomEntityMapper.getInstance().mapPanacheEntity(entityRoom);

        assertTrue(genRoomPayload.getId() == 0);
        assertTrue(genRoomPayload.getName().equals("Backroom"));
        assertTrue(genRoomPayload.getDescription().equals("Once entered, one never leaves again"));
    }

    @Test
    public void testRoomEntityMapperGenEntityToPanacheEntity() {
        GenRoom genRoomPayload = new GenRoom();
        genRoomPayload.setId(0);
        genRoomPayload.setName("Backroom");
        genRoomPayload.setDescription("Once entered, one never leaves again");

        EntityRoom entityRoom = RoomEntityMapper.getInstance().mapGenEntity(genRoomPayload);

        assertTrue(entityRoom.getId() == 0);
        assertTrue(entityRoom.getName().equals("Backroom"));
        assertTrue(entityRoom.getDescription().equals("Once entered, one never leaves again"));
    }

    @Test
    public void testRoomEntityMapperPayloadToPanacheEntity() {
        GenRoomPayload genRoomPayload = new GenRoomPayload();
        genRoomPayload.setName("Backroom");
        genRoomPayload.description("Once entered, one never leaves again");

        EntityRoom entityRoom = RoomEntityMapper.getInstance().mapPayload(genRoomPayload);

        assertTrue(entityRoom.getName().equals("Backroom"));
        assertTrue(entityRoom.getDescription().equals("Once entered, one never leaves again"));
    }

}
