package edu.matc;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloWorld {
    // Define what type of request this method responds to
    @GET

    //Define what type of content is produced
    /*@Produces("text/plain")
    public Response getMessage() {
        //return a simple greeting
        String output = "Hello Everyone!";
        return Response.status(200).entity(output).build();
    }*/

    @Produces("text/plain")
    @Path("/{param}")
    public Response getMessage(@PathParam("param") String msg) {
        String output = "Hello " + msg;
        return Response.status(200).entity(output).build();
    }


}
