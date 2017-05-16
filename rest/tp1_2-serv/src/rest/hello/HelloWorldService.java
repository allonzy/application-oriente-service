package rest.hello;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.parsers.*;

import org.w3c.dom.*;
@Path("/")
public class HelloWorldService {
	@Path("hello")
	@GET
	//@PathParam("name") String name
	public Response hello(
			
			){
		String name = "toto";
		try{
		 	DocumentBuilder xmlbuilder = DocumentBuilderFactory
		 			.newInstance()
		 			.newDocumentBuilder();
		 	Document xmlDoc = xmlbuilder.newDocument();
		 	Element root = xmlDoc.createElement("bonjour");
		 	xmlDoc.appendChild(root);
		 	root.appendChild(xmlDoc.createTextNode("bonjour "+name));

			return Response
				   .status(200)
				   .type(MediaType.APPLICATION_XML)
				   .entity(xmlDoc)
				   .build();
		}catch(ParserConfigurationException e){
			e.printStackTrace();
			return  Response
				   .status(500)
				   .build();
		}
	}
	@GET
	@Path("ola")
	//@PathParam("name") String name
	public Response ola(
			
			){
		String name = "toto";
		return Response
			   .status(200)
			   .type(MediaType.TEXT_HTML)
			   .entity("hello "+name)
			   .build();

	}
}
