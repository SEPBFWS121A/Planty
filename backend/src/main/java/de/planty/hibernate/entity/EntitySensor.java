package de.planty.hibernate.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.Date;

@Entity
public class EntitySensor extends PanacheEntityBase {

    @Id
    @SequenceGenerator(name = "guidelineSequence", sequenceName = "guideline_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guidelineSequence")
    private @Valid Integer id;
    private @Valid String hardwareId;
    private @Valid String name;
    private @Valid String description;
    private @Valid Integer humidityScalingFrom;
    private @Valid Integer humidityScalingTo;
    private @Valid Date lastCalibration;
    private @Valid Integer sleepTimeout;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHardwareId() {
        return hardwareId;
    }

    public void setHardwareId(String hardwareID) {
        this.hardwareId = hardwareID;
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

    public Integer getHumidityScalingFrom() {
        return humidityScalingFrom;
    }

    public void setHumidityScalingFrom(Integer humidityScalingFrom) {
        this.humidityScalingFrom = humidityScalingFrom;
    }

    public Integer getHumidityScalingTo() {
        return humidityScalingTo;
    }

    public void setHumidityScalingTo(Integer humidityScalingTo) {
        this.humidityScalingTo = humidityScalingTo;
    }

    public Date getLastCalibration() {
        return lastCalibration;
    }

    public void setLastCalibration(Date lastCalibration) {
        this.lastCalibration = lastCalibration;
    }

    public Integer getSleepTimeout() {
        return sleepTimeout;
    }

    public void setSleepTimeout(Integer sleepTimeout) {
        this.sleepTimeout = sleepTimeout;
    }
}
