package de.planty.gen.api;

import de.planty.gen.model.GenErrorMessage;
import de.planty.gen.model.GenMoistureRecord;
import de.planty.gen.model.GenMoistureRecordPayload;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;


import java.io.InputStream;
import java.util.Map;
import java.util.List;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

@Path("/moistureRecord")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen")
public interface MoistureRecordApi {

    @GET
    @Path("/byPlant/{plantId}")
    @Produces({ "application/json" })
    Response moistureRecordByPlantPlantIdGet(@PathParam("plantId") String plantId);

    @GET
    @Produces({ "application/json" })
    Response moistureRecordGet();

    @DELETE
    @Path("/{moistureRecordId}")
    @Produces({ "application/json" })
    Response moistureRecordMoistureRecordIdDelete(@PathParam("moistureRecordId") String moistureRecordId);

    @GET
    @Path("/{moistureRecordId}")
    @Produces({ "application/json" })
    Response moistureRecordMoistureRecordIdGet(@PathParam("moistureRecordId") String moistureRecordId);

    @POST
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response moistureRecordPost(@Valid GenMoistureRecordPayload genMoistureRecordPayload);
}
