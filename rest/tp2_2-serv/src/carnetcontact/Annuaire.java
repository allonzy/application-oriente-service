package carnetcontact;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
@Path("/annuaire")
public class Annuaire {
	private static 	Carnet carnet = new Carnet();

	@GET
	public Response printContact(){
		String carnetContent = carnet.isEmpty()?
							  "Liste vide":
			   				  carnet.toString();
		return Response
			   .status(200)
			   .entity(carnetContent)
			   .build();
	}
	@GET
	@Path("{contactName}")
	public Response printContact(
		@PathParam("contactName") String name
		){
		if(name == null
		|| name.equals("")){
		return Response
			   .status(200)
			   .entity("Renseignez un nom")
			   .build();
		}
		Contact contact = carnet.getContactByName(name);
		if(contact == null){
			return Response
			   .status(200)
			   .entity("Inconnu")
			   .build();
		}else{
			return Response
			   .status(200)
			   .entity(contact.getNumero())
			   .build();
		}
	}
}
