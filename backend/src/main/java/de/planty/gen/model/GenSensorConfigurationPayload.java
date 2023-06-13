package de.planty.gen.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("sensorConfigurationPayload")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen")
public class GenSensorConfigurationPayload   {
  private @Valid Integer humidityScalingFrom;
  private @Valid Integer humidityScalingTo;
  private @Valid Integer sleepTimeout;

  /**
   * The minimum value used for scaling the raw sensor values.
   **/
  public GenSensorConfigurationPayload humidityScalingFrom(Integer humidityScalingFrom) {
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
  public GenSensorConfigurationPayload humidityScalingTo(Integer humidityScalingTo) {
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
   * Timeout in minutes for the sensor to sleep in between taking measurements
   **/
  public GenSensorConfigurationPayload sleepTimeout(Integer sleepTimeout) {
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
    GenSensorConfigurationPayload sensorConfigurationPayload = (GenSensorConfigurationPayload) o;
    return Objects.equals(this.humidityScalingFrom, sensorConfigurationPayload.humidityScalingFrom) &&
        Objects.equals(this.humidityScalingTo, sensorConfigurationPayload.humidityScalingTo) &&
        Objects.equals(this.sleepTimeout, sensorConfigurationPayload.sleepTimeout);
  }

  @Override
  public int hashCode() {
    return Objects.hash(humidityScalingFrom, humidityScalingTo, sleepTimeout);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GenSensorConfigurationPayload {\n");
    
    sb.append("    humidityScalingFrom: ").append(toIndentedString(humidityScalingFrom)).append("\n");
    sb.append("    humidityScalingTo: ").append(toIndentedString(humidityScalingTo)).append("\n");
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

