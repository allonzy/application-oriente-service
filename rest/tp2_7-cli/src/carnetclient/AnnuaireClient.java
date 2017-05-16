package carnetclient;

import java.util.*; 

import carnetcontact.*;
import javax.ws.rs.client.*;
import javax.ws.rs.core.*;
import org.glassfish.jersey.client.ClientConfig;

public class AnnuaireClient {
	public static void main(String[] args) {
		ClientConfig config= new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget webTargetCarnetService = client.target(UriBuilder.fromUri("http://ge-st1-116:8080/carnetContactService/rest").build());
		WebTarget annuaireTarget = webTargetCarnetService.path("annuaire"); 
		WebTarget addTarget = annuaireTarget.path("add");

		Scanner sc = new Scanner(System.in);
		System.out.println("entrez le nom");
		String nom = sc.next();
		System.out.println("entrez le numero");
		String numero = sc.next();
		Contact contact = new Contact(nom,numero);
		Response response = addTarget
							.request()
							.post(Entity.xml(contact));
		System.out.println(response.getLocation());	
	}
}
