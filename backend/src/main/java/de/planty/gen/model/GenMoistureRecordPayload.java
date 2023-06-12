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



@JsonTypeName("moistureRecordPayload")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen")
public class GenMoistureRecordPayload   {
  private @Valid Date timestamp;
  private @Valid Integer humidityLevel;
  private @Valid Integer plantId;

  /**
   * A timestamp containing date and time.
   **/
  public GenMoistureRecordPayload timestamp(Date timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  
  @JsonProperty("timestamp")
  public Date getTimestamp() {
    return timestamp;
  }

  @JsonProperty("timestamp")
  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  /**
   * Humidity level reported by a sensor scaled from 0 to 100.
   * minimum: 0
   * maximum: 100
   **/
  public GenMoistureRecordPayload humidityLevel(Integer humidityLevel) {
    this.humidityLevel = humidityLevel;
    return this;
  }

  
  @JsonProperty("humidityLevel")
 @Min(0) @Max(100)  public Integer getHumidityLevel() {
    return humidityLevel;
  }

  @JsonProperty("humidityLevel")
  public void setHumidityLevel(Integer humidityLevel) {
    this.humidityLevel = humidityLevel;
  }

  /**
   * The ID schema used for most database entities.
   * minimum: 0
   **/
  public GenMoistureRecordPayload plantId(Integer plantId) {
    this.plantId = plantId;
    return this;
  }

  
  @JsonProperty("plantId")
 @Min(0)  public Integer getPlantId() {
    return plantId;
  }

  @JsonProperty("plantId")
  public void setPlantId(Integer plantId) {
    this.plantId = plantId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GenMoistureRecordPayload moistureRecordPayload = (GenMoistureRecordPayload) o;
    return Objects.equals(this.timestamp, moistureRecordPayload.timestamp) &&
        Objects.equals(this.humidityLevel, moistureRecordPayload.humidityLevel) &&
        Objects.equals(this.plantId, moistureRecordPayload.plantId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timestamp, humidityLevel, plantId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GenMoistureRecordPayload {\n");
    
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    humidityLevel: ").append(toIndentedString(humidityLevel)).append("\n");
    sb.append("    plantId: ").append(toIndentedString(plantId)).append("\n");
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

