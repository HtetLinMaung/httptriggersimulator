package com.mit;

import java.util.HashMap;
import java.util.Map;
import com.starless.http.HttpRequest;
import com.starless.http.HttpResponse;
import com.starless.http.HttpUtils;
import com.starless.http.RequestMapper;
import com.starless.http.ResponseMapper;

import jakarta.ws.rs.*;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/{route: .*}")
@Produces(MediaType.APPLICATION_JSON)
public class FunctionResource {
    @GET
    public Response getMethod(@PathParam("route") String route, @Context ContainerRequestContext crc) {
        return ResponseMapper.map(echo(RequestMapper.map(crc, Void.class)));
    }

    public HttpResponse<?> echo(HttpRequest<Void> request) {
        Map<String, String> headers = HttpUtils.getCORSHeaders();
        headers.put("Content-Type", "text/plain");

        Map<String, Object> body = new HashMap<String, Object>() {
            {
                put("code", 200);
                put("message", "Successfully executed");
            }
        };

        return HttpResponse.builder()
                .status(200)
                .headers(headers)
                .body(body)
                .build();
    }
}
