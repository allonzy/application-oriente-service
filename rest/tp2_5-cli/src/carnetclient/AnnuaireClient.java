package carnetclient;

import java.util.*; 

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
		Form form = new Form();
		System.out.println("entrez le nom");
		String nom = sc.next();
		form.param("nom", nom);
		System.out.println("entrez le numero");
		String numero = sc.next();
		form.param("numero",numero);
		Response response = addTarget
							.request()
							.post(Entity.form(form));
		System.out.println(response.getLocation());
	}
}
