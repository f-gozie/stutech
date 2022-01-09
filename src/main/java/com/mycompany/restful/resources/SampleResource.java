package com.mycompany.restful.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("sample")
public class SampleResource {

	@Inject
	@ConfigProperty(name = "message")
	private String message;

	@GET
	public Response message() {
		return Response.ok(message).build();
	}

        @GET
        @Path("testy/{name}")
        public String ping(@PathParam("name") String name) {
            return "Hello " + name;
        }
}
