package carnetcontact;

import java.net.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.*;


public class ContactNotFoundPlainException extends WebApplicationException{
	private static final long serialVersionUID = 1L;
	public ContactNotFoundPlainException(){
		super("Contact inconnu");
	}
	public Response getResponse(){
		return Response
		.status(404)
		.entity("Ce contact est inconnu")
		.build();
	}
}