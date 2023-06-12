package de.planty.gen.api;

import de.planty.gen.model.GenErrorMessage;
import de.planty.gen.model.GenPlantType;
import de.planty.gen.model.GenPlantTypePayload;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;


import java.io.InputStream;
import java.util.Map;
import java.util.List;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

@Path("/plantType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen")
public interface PlantTypeApi {

    @GET
    @Produces({ "application/json" })
    Response plantTypeGet();

    @DELETE
    @Path("/{plantTypeId}")
    @Produces({ "application/json" })
    Response plantTypePlantTypeIdDelete(@PathParam("plantTypeId") String plantTypeId);

    @GET
    @Path("/{plantTypeId}")
    @Produces({ "application/json" })
    Response plantTypePlantTypeIdGet(@PathParam("plantTypeId") String plantTypeId);

    @POST
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response plantTypePost(@Valid GenPlantTypePayload genPlantTypePayload);
}
