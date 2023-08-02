package com.mit;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/{route: .*}")
@Produces(MediaType.APPLICATION_JSON)
public class FunctionResource {
    @GET
    public Response getMethod(@PathParam("route") String route) {
        // Here, you can decide which method to call based on the "route"
        // For example:
        // if ("method1".equals(route)) {
        // return Response.ok(MyClass.method1()).build();
        // } else if ("method2".equals(route)) {
        // return Response.ok(MyClass.method2()).build();
        // } else {
        // return Response.status(Response.Status.NOT_FOUND).build();
        // }
        return Response.ok(route).build();
    }
}
