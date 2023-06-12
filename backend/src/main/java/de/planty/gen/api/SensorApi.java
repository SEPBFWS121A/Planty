package de.planty.gen.api;

import de.planty.gen.model.GenErrorMessage;
import de.planty.gen.model.GenSensor;
import de.planty.gen.model.GenSensorConfigurationPayload;
import de.planty.gen.model.GenSensorPayload;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;


import java.io.InputStream;
import java.util.Map;
import java.util.List;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

@Path("/sensor")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen")
public interface SensorApi {

    @GET
    @Path("/by-hardware-id/{hardwareId}")
    @Produces({ "application/json" })
    Response sensorByHardwareIdHardwareIdGet(@PathParam("hardwareId") String hardwareId);

    @GET
    @Produces({ "application/json" })
    Response sensorGet();

    @POST
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response sensorPost(@Valid GenSensorPayload genSensorPayload);

    @DELETE
    @Path("/{sensorId}")
    @Produces({ "application/json" })
    Response sensorSensorIdDelete(@PathParam("sensorId") String sensorId);

    @GET
    @Path("/{sensorId}")
    @Produces({ "application/json" })
    Response sensorSensorIdGet(@PathParam("sensorId") String sensorId);

    @PUT
    @Path("/{sensorId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response sensorSensorIdPut(@PathParam("sensorId") String sensorId,@Valid GenSensorConfigurationPayload genSensorConfigurationPayload);
}
