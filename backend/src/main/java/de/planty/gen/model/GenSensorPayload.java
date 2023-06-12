package de.planty.gen.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("sensorPayload")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen")
public class GenSensorPayload   {
  private @Valid String hardwareId;
  private @Valid String name;
  private @Valid String description;

  /**
   * The hardware specific ID of a sensor.
   **/
  public GenSensorPayload hardwareId(String hardwareId) {
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
  public GenSensorPayload name(String name) {
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
  public GenSensorPayload description(String description) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GenSensorPayload sensorPayload = (GenSensorPayload) o;
    return Objects.equals(this.hardwareId, sensorPayload.hardwareId) &&
        Objects.equals(this.name, sensorPayload.name) &&
        Objects.equals(this.description, sensorPayload.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hardwareId, name, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GenSensorPayload {\n");
    
    sb.append("    hardwareId: ").append(toIndentedString(hardwareId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

