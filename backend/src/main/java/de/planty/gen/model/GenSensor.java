package de.planty.gen.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.Date;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("sensor")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen")
public class GenSensor   {
  private @Valid Integer id;
  private @Valid String hardwareId;
  private @Valid String name;
  private @Valid String description;
  private @Valid Integer humidityScalingFrom;
  private @Valid Integer humidityScalingTo;
  private @Valid Date lastCalibration;
  private @Valid Integer sleepTimeout;

  /**
   * The ID schema used for most database entities.
   * minimum: 0
   **/
  public GenSensor id(Integer id) {
    this.id = id;
    return this;
  }

  
  @JsonProperty("id")
 @Min(0)  public Integer getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * The hardware specific ID of a sensor.
   **/
  public GenSensor hardwareId(String hardwareId) {
    this.hardwareId = hardwareId;
    return this;
  }

  
  @JsonProperty("hardwareId")
 @Size(max=50)  public String getHardwareId() {
    return hardwareId;
  }

  @JsonProperty("hardwareId")
  public void setHardwareId(String hardwareId) {
    this.hardwareId = hardwareId;
  }

  /**
   * A name of an entity
   **/
  public GenSensor name(String name) {
    this.name = name;
    return this;
  }

  
  @JsonProperty("name")
 @Size(max=50)  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  /**
   * A description of an entity
   **/
  public GenSensor description(String description) {
    this.description = description;
    return this;
  }

  
  @JsonProperty("description")
 @Size(max=50)  public String getDescription() {
    return description;
  }

  @JsonProperty("description")
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * The minimum value used for scaling the raw sensor values.
   **/
  public GenSensor humidityScalingFrom(Integer humidityScalingFrom) {
    this.humidityScalingFrom = humidityScalingFrom;
    return this;
  }

  
  @JsonProperty("humidityScalingFrom")
  public Integer getHumidityScalingFrom() {
    return humidityScalingFrom;
  }

  @JsonProperty("humidityScalingFrom")
  public void setHumidityScalingFrom(Integer humidityScalingFrom) {
    this.humidityScalingFrom = humidityScalingFrom;
  }

  /**
   * The maximum value used for scaling the raw sensor values.
   **/
  public GenSensor humidityScalingTo(Integer humidityScalingTo) {
    this.humidityScalingTo = humidityScalingTo;
    return this;
  }

  
  @JsonProperty("humidityScalingTo")
  public Integer getHumidityScalingTo() {
    return humidityScalingTo;
  }

  @JsonProperty("humidityScalingTo")
  public void setHumidityScalingTo(Integer humidityScalingTo) {
    this.humidityScalingTo = humidityScalingTo;
  }

  /**
   * A timestamp containing date and time.
   **/
  public GenSensor lastCalibration(Date lastCalibration) {
    this.lastCalibration = lastCalibration;
    return this;
  }

  
  @JsonProperty("lastCalibration")
  public Date getLastCalibration() {
    return lastCalibration;
  }

  @JsonProperty("lastCalibration")
  public void setLastCalibration(Date lastCalibration) {
    this.lastCalibration = lastCalibration;
  }

  /**
   * Timeout in minutes for the sensor to sleep in between taking measurements
   **/
  public GenSensor sleepTimeout(Integer sleepTimeout) {
    this.sleepTimeout = sleepTimeout;
    return this;
  }

  
  @JsonProperty("sleepTimeout")
  public Integer getSleepTimeout() {
    return sleepTimeout;
  }

  @JsonProperty("sleepTimeout")
  public void setSleepTimeout(Integer sleepTimeout) {
    this.sleepTimeout = sleepTimeout;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GenSensor sensor = (GenSensor) o;
    return Objects.equals(this.id, sensor.id) &&
        Objects.equals(this.hardwareId, sensor.hardwareId) &&
        Objects.equals(this.name, sensor.name) &&
        Objects.equals(this.description, sensor.description) &&
        Objects.equals(this.humidityScalingFrom, sensor.humidityScalingFrom) &&
        Objects.equals(this.humidityScalingTo, sensor.humidityScalingTo) &&
        Objects.equals(this.lastCalibration, sensor.lastCalibration) &&
        Objects.equals(this.sleepTimeout, sensor.sleepTimeout);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, hardwareId, name, description, humidityScalingFrom, humidityScalingTo, lastCalibration, sleepTimeout);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GenSensor {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    hardwareId: ").append(toIndentedString(hardwareId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    humidityScalingFrom: ").append(toIndentedString(humidityScalingFrom)).append("\n");
    sb.append("    humidityScalingTo: ").append(toIndentedString(humidityScalingTo)).append("\n");
    sb.append("    lastCalibration: ").append(toIndentedString(lastCalibration)).append("\n");
    sb.append("    sleepTimeout: ").append(toIndentedString(sleepTimeout)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


}

