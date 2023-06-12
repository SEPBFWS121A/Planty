package de.planty.util;

import org.jboss.resteasy.reactive.RestResponse;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class ErrorResponseBuilder {

    private String message;
    private int statusCode;

    public ErrorResponseBuilder(String message, int statusCode){
        this.message = message;
        this.statusCode = statusCode;
    }

    public ErrorResponseBuilder(String message){
        this(message, RestResponse.StatusCode.BAD_REQUEST);
    }

    public ErrorResponseBuilder(){
        this("No further information provided", RestResponse.StatusCode.BAD_REQUEST);
    }

    public ErrorResponseBuilder setMessage(String message) {
        this.message = message;
        return this;
    }

    public ErrorResponseBuilder setStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public Response build() {
        if(message == null || message.length() > 256) //As defined in OpenAPI configuration in schema "errorMessage"
            throw new IllegalArgumentException("The message exceeds the maximum length of 256.");

        return Response.status(statusCode).type(MediaType.APPLICATION_JSON).entity(String.format("{\"message\": \"%s\"}", message)).build();
    }

}
