package carnetcontact;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
@Path("/annuaire")
public class Annuaire {
	private static 	Carnet carnet = new Carnet();

	@GET
	public Response printContactList(){
		String carnetContent = carnet.isEmpty()?
							  "Liste vide":
			   				  carnet.toString();
		return Response
			   .status(200)
			   .entity(carnetContent)
			   .build();
	}
}
