package rest.hello;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
@Path("/")
public class HelloWorldService {
	@Path("hello")
	@GET
	public Response hello(
			@QueryParam("name") String name
			){
		return Response
			   .status(200)
			   .entity("hello "+name)
			   .build();
	}
	@Path("salut")
	@GET
	public Response salut(
			@DefaultValue("bel inconnu") @QueryParam("name") String name
			){
		return Response
			   .status(200)
			   .entity("salut "+name)
			   .build();
	}
}
