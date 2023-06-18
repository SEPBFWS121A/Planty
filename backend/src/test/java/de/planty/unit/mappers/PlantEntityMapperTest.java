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
        entityPlant.setId(0);
        entityPlant.setName("Tannenbaum");
        entityPlant.setDescription("Ab dem 1.1. wird es Peilich...");
        entityPlant.setPlantTypeId(24);
        entityPlant.setSensorId(12);
        entityPlant.setRoomId(23);

        GenPlant genPlantPayload = PlantEntityMapper.getInstance().mapPanacheEntity(entityPlant);

        assertTrue(genPlantPayload.getName().equals(entityPlant.getName()));
        assertTrue(genPlantPayload.getDescription().equals(entityPlant.getDescription()));
        assertTrue(genPlantPayload.getPlantTypeId() == entityPlant.getPlantTypeId());
        assertTrue(genPlantPayload.getSensorId() == entityPlant.getSensorId());
        assertTrue(genPlantPayload.getRoomId() == entityPlant.getRoomId());
    }

    @Test
    public void testPlantEntityMapperGenEntityToPanacheEntity() {
        GenPlant genPlant = new GenPlant();
        genPlant.setId(0);
        genPlant.setName("Tannenbaum");
        genPlant.setDescription("Ab dem 1.1. wird es Peilich...");
        genPlant.setPlantTypeId(24);
        genPlant.setSensorId(12);
        genPlant.setRoomId(23);

        EntityPlant entityPlant = PlantEntityMapper.getInstance().mapGenEntity(genPlant);

        assertTrue(entityPlant.getId() == genPlant.getId());
        assertTrue(entityPlant.getName().equals(genPlant.getName()));
        assertTrue(entityPlant.getDescription().equals(genPlant.getDescription()));
        assertTrue(entityPlant.getPlantTypeId() == genPlant.getPlantTypeId());
        assertTrue(entityPlant.getSensorId() == genPlant.getSensorId());
        assertTrue(entityPlant.getRoomId() == genPlant.getRoomId());
    }

    @Test
    public void testRoomEntityMapperPayloadToPanacheEntity() {
        GenPlantPayload genPlantPayload = new GenPlantPayload();
        genPlantPayload.setName("Tannenbaum");
        genPlantPayload.setDescription("Ab dem 1.1. wird es Peilich...");
        genPlantPayload.setPlantTypeId(24);
        genPlantPayload.setSensorId(12);
        genPlantPayload.setRoomId(23);

        EntityPlant entityPlant = PlantEntityMapper.getInstance().mapPayload(genPlantPayload);

        assertTrue(entityPlant.getName().equals(genPlantPayload.getName()));
        assertTrue(entityPlant.getDescription().equals(genPlantPayload.getDescription()));
        assertTrue(entityPlant.getPlantTypeId() == genPlantPayload.getPlantTypeId());
        assertTrue(entityPlant.getSensorId() == genPlantPayload.getSensorId());
        assertTrue(entityPlant.getRoomId() == genPlantPayload.getRoomId());
    }
}