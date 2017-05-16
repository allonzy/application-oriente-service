package rest.hello;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
@Path("/hello")
public class HelloWorldService {
	//@Path("")
	@GET
	//@PathParam("name") String name
	public Response hello(
			
			){
		return Response
			   .status(200)
			   .entity("hello "+"toto")
			   .build();
	}
}
