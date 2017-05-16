package rest.hello;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
@Path("/")
public class HelloWorldService {
	@Path("hello/{name}")
	@GET
	public Response hello(
			@PathParam("name") String name
			){
		return Response
			   .status(200)
			   .entity("hello "+name)
			   .build();
	}
}
