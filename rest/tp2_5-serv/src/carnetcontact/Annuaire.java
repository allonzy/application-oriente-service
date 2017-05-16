package carnetcontact;

import java.net.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/annuaire")
public class Annuaire {
	private static Carnet carnet = new Carnet();
	@GET
	public Response printContact(){
		Carnet carnet = new Carnet();
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
	@POST
	@Path("add")
	public Response addContact(
			@FormParam("nom") String name,
			@FormParam("numero") String numero
			){
		Contact contact = carnet.getContactByName(name);
		if(contact != null){
			return Response
				   .status(200)
				   .entity("Contact "+name+" déjà existant")
				   .build();
		}else{
			URI uri = URI.create("/annuaire/"+name);
			carnet.add(new Contact(name,numero));
			return Response
					.created(uri)
					.build();
		}
	}
}
