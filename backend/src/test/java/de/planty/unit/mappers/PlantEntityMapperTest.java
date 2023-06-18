package de.planty.unit.mappers;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import de.planty.gen.model.GenPlant;
import de.planty.gen.model.GenPlantPayload;
import de.planty.hibernate.entity.EntityPlant;
import de.planty.hibernate.mapper.PlantEntityMapper;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PlantEntityMapperTest {

    @Test
    public void testPlantEntityMapperPanacheEntityToGenEntity() {
        EntityPlant entityPlant = new EntityPlant();
        entityPlant.setName("Tannenbaum");
        entityPlant.setDescription("Ab dem 1.1. wird es Peilich...");
        entityPlant.setPlantTypeId(24);
        entityPlant.setSensorId(12);
        entityPlant.setRoomId(23);


        GenPlant genPlantPayload = PlantEntityMapper.getInstance().mapPanacheEntity(entityPlant);

        assertTrue(genPlantPayload.getName().equals("Tannenbaum");
        assertTrue(genPlantPayload.getDescription().equals("Ab dem 1.1. wird es Peilich...");
        assertTrue(genPlantPayload.getPlantTypeId() == 24);
        assertTrue(genPlantPayload.getSensorId() == 12);
        assertTrue(genPlantPayload.getRoomId() == 23);
    }

    @Test
    public void testPlantEntityMapperGenEntityToPanacheEntity() {
        GenRoom genRoomPayload = new GenRoom();
        genRoomPayload.setName("Tannenbaum");
        genRoomPayload.setDescription("Ab dem 1.1. wird es Peilich...");
        genRoomPayload.setPlantTypeId(24);
        genRoomPayload.setSensorId(12);
        genRoomPayload.setRoomId(23);


        EntityRoom entityRoom = RoomEntityMapper.getInstance().mapGenEntity(genRoomPayload);

        assertTrue(entityRoom.getId() == 0);
        assertTrue(entityRoom.getName().equals("Tannenbaum");
        assertTrue(entityRoom.getDescription().equals("Ab dem 1.1. wird es Peilich...");
        assertTrue(entityRoom.getPlantTypeId() == 24);
        assertTrue(entityRoom.getSensorId() == 12);
        assertTrue(entityRoom.getRoomId() == 23);
    }

    @Test
    public void testRoomEntityMapperPayloadToPanacheEntity() {
        GenPlantPayload genPlantPayload = new GenPlantPayload();
        genPlantPayload.setName("Tannenbaum");
        genPlantPayload.setDescription("Ab dem 1.1. wird es Peilich...");

        EntityPlant entityPlant = PlantEntityMapper.getInstance().mapPayload(genPlantPayload);

        assertTrue(entityRoom.getName().equals("Tannenbaum"));
        assertTrue(entityRoom.getDescription().equals("Ab dem 1.1. wird es Peilich..."));
    }

}
