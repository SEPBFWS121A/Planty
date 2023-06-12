package de.planty.gen.api;

import de.planty.gen.model.GenErrorMessage;
import de.planty.gen.model.GenRoom;
import de.planty.gen.model.GenRoomPayload;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;


import java.io.InputStream;
import java.util.Map;
import java.util.List;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

@Path("/room")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen")
public interface RoomApi {

    @GET
    @Produces({ "application/json" })
    Response roomGet();

    @POST
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response roomPost(@Valid GenRoomPayload genRoomPayload);

    @DELETE
    @Path("/{roomId}")
    @Produces({ "application/json" })
    Response roomRoomIdDelete(@PathParam("roomId") String roomId);

    @GET
    @Path("/{roomId}")
    @Produces({ "application/json" })
    Response roomRoomIdGet(@PathParam("roomId") String roomId);
}
