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
        GenPlant genPlantPayload = new GenPlant();
        genPlantPayload.setName("Tannenbaum");
        genPlantPayload.setDescription("Ab dem 1.1. wird es Peilich...");
        genPlantPayload.setPlantTypeId(24);
        genPlantPayload.setSensorId(12);
        genPlantPayload.setRoomId(23);


        EntityPlant entityPlant = PlantEntityMapper.getInstance().mapGenEntity(genPlantPayload);

        assertTrue(entityPlant.getId() == 0);
        assertTrue(entityPlant.getName().equals("Tannenbaum");
        assertTrue(entityPlant.getDescription().equals("Ab dem 1.1. wird es Peilich...");
        assertTrue(entityPlant.getPlantTypeId() == 24);
        assertTrue(entityPlant.getSensorId() == 12);
        assertTrue(entityPlant.getRoomId() == 23);
    }

    @Test
    public void testPlantEntityMapperPayloadToPanacheEntity() {
        GenPlantPayload genPlantPayload = new GenPlantPayload();
        genPlantPayload.setName("Tannenbaum");
        genPlantPayload.setDescription("Ab dem 1.1. wird es Peilich...");

        EntityPlant entityPlant = PlantEntityMapper.getInstance().mapPayload(genPlantPayload);

        assertTrue(entityPlant.getName().equals("Tannenbaum"));
        assertTrue(entityPlant.getDescription().equals("Ab dem 1.1. wird es Peilich..."));
    }

}
