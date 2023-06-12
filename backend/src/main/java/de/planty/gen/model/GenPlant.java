package de.planty.gen.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("plant")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen")
public class GenPlant   {
  private @Valid Integer id;
  private @Valid String name;
  private @Valid String description;
  private @Valid Integer plantTypeId;
  private @Valid Integer sensorId;
  private @Valid Integer roomId;

  /**
   * The ID schema used for most database entities.
   * minimum: 0
   **/
  public GenPlant id(Integer id) {
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
   * A name of an entity
   **/
  public GenPlant name(String name) {
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
  public GenPlant description(String description) {
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
   * The ID schema used for most database entities.
   * minimum: 0
   **/
  public GenPlant plantTypeId(Integer plantTypeId) {
    this.plantTypeId = plantTypeId;
    return this;
  }

  
  @JsonProperty("plantTypeId")
 @Min(0)  public Integer getPlantTypeId() {
    return plantTypeId;
  }

  @JsonProperty("plantTypeId")
  public void setPlantTypeId(Integer plantTypeId) {
    this.plantTypeId = plantTypeId;
  }

  /**
   * The ID schema used for most database entities.
   * minimum: 0
   **/
  public GenPlant sensorId(Integer sensorId) {
    this.sensorId = sensorId;
    return this;
  }

  
  @JsonProperty("sensorId")
 @Min(0)  public Integer getSensorId() {
    return sensorId;
  }

  @JsonProperty("sensorId")
  public void setSensorId(Integer sensorId) {
    this.sensorId = sensorId;
  }

  /**
   * The ID schema used for most database entities.
   * minimum: 0
   **/
  public GenPlant roomId(Integer roomId) {
    this.roomId = roomId;
    return this;
  }

  
  @JsonProperty("roomId")
 @Min(0)  public Integer getRoomId() {
    return roomId;
  }

  @JsonProperty("roomId")
  public void setRoomId(Integer roomId) {
    this.roomId = roomId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GenPlant plant = (GenPlant) o;
    return Objects.equals(this.id, plant.id) &&
        Objects.equals(this.name, plant.name) &&
        Objects.equals(this.description, plant.description) &&
        Objects.equals(this.plantTypeId, plant.plantTypeId) &&
        Objects.equals(this.sensorId, plant.sensorId) &&
        Objects.equals(this.roomId, plant.roomId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, plantTypeId, sensorId, roomId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GenPlant {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    plantTypeId: ").append(toIndentedString(plantTypeId)).append("\n");
    sb.append("    sensorId: ").append(toIndentedString(sensorId)).append("\n");
    sb.append("    roomId: ").append(toIndentedString(roomId)).append("\n");
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

