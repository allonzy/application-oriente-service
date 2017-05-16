package carnetcontact;

import java.net.*;
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
	public Response printContact (
			@PathParam("contactName") String name
		)
			throws ContactNotFoundPlainException
		{
		if(name == null
		|| name.equals("")){
		return Response
			   .status(200)
			   .entity("Renseignez un nom")
			   .build();
		}
		Contact contact = carnet.getContactByName(name);
		return Response
		   .status(200)
		   .entity(contact)
		   .build();
	}
	@POST
	@Path("add")
	public Response addContact(
				@FormParam("nom") String name,
				@FormParam("numero") String numero
			){
		try{
		Contact contact = carnet.getContactByName(name);
		return Response
			   .status(200)
			   .entity("Contact "+name+" déjà existant")
			   .build();
		}catch(ContactNotFoundPlainException e1){
			carnet.add(new Contact(name,numero));
			URI uri = URI.create("/rest/annuaire/"+name);
			return Response
					.created(uri)
					.build();
		}
	}
	@PUT
	@Path("put")
	public Response putContact(Contact contact){
		try{
			contact = carnet.getContactByName(contact.getNom());
			carnet.setContact(contact);
			// URI uri = URI.create("/rest/annuaire/"+contact.getNom());
			return Response
				   .ok(contact)
				   .build();
		}catch(ContactNotFoundPlainException e1){
			carnet.add(contact);
			return Response
					.status(204)
					.build();
		}
	}
	@DELETE
	@Path("{contactName}")
	public Response deleteContact(
			@PathParam("contactName") String contactName)
	throws ContactNotFoundPlainException{
		Contact contact = carnet.getContactByName(contactName) ;
		if( contact != null ){
			carnet.remove(contact);
			// URI uri = URI.create("/rest/annuaire/"+contact.getNom());
			return Response
				   .ok()
				   .build();
		}else{
			carnet.add(contact);
			return Response
					.status(204)
					.build();
		}
	}
}
