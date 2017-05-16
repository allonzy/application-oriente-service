package carnetclient;

import java.util.*; 

import javax.ws.rs.client.*;
import javax.ws.rs.core.*;
import org.glassfish.jersey.client.ClientConfig;


public class AnnuaireClient {
	public static void main(String[] args) {
		ClientConfig config= new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget webTargetCarnetService = client.target(UriBuilder.fromUri("http://ge-st1-116:8080/carnetContactService/").build());
		WebTarget annuaireTarget =  webTargetCarnetService.path("annuaire");
		String annuaire = annuaireTarget
						 	.request()
						 	.get(String.class);
		System.out.println(annuaire);
		System.out.println("choisissez un contact");

		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		String numero = annuaireTarget.path(name)
		.request()
		.accept(MediaType.TEXT_PLAIN)
  		.get(String.class);
		System.out.println(numero);
	}
}
