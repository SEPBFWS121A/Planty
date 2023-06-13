package de.planty.hibernate.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import jakarta.persistence.*;

@Entity
public class EntityPlant extends PanacheEntityBase {

    @Id
    @SequenceGenerator(name = "guidelineSequence", sequenceName = "guideline_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guidelineSequence")
    private Integer id;
    private String name;
    private String description;
    private Integer plantTypeId;
    private Integer sensorId;
    private Integer roomId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPlantTypeId() {
        return plantTypeId;
    }

    public void setPlantTypeId(Integer plantTypeId) {
        this.plantTypeId = plantTypeId;
    }

    public Integer getSensorId() {
        return sensorId;
    }

    public void setSensorId(Integer sensorId) {
        this.sensorId = sensorId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }
}
