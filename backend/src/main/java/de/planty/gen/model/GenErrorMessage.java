package de.planty.gen.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
import javax.validation.Valid;

import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * A json object containing a text message describing an error.
 **/
@ApiModel(description = "A json object containing a text message describing an error.")
@JsonTypeName("errorMessage")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2022-11-16T18:35:52.147312+01:00[Europe/Berlin]")
public class GenErrorMessage   {
  private @Valid String message;

  /**
   * A message describing an error.
   **/
  public GenErrorMessage message(String message) {
    this.message = message;
    return this;
  }

  
  @ApiModelProperty(example = "The database is not responding.", value = "A message describing an error.")
  @JsonProperty("message")
 @Size(max=256)  public String getMessage() {
    return message;
  }

  @JsonProperty("message")
  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GenErrorMessage errorMessage = (GenErrorMessage) o;
    return Objects.equals(this.message, errorMessage.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GenErrorMessage {\n");
    
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
