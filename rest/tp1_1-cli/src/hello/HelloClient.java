package hello;

import javax.ws.rs.client.*;
import javax.ws.rs.core.*;
import org.glassfish.jersey.client.ClientConfig;

public class HelloClient {
	public static void main(String[] args) {
		ClientConfig config= new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget webTarget = client.target(UriBuilder.fromUri("http://localhost:8080/HelloWorldService/").build());
		String helloMe = webTarget.path("hello")
		.request()
		.accept(MediaType.TEXT_PLAIN)
  		.get(String.class);		
		System.out.println(helloMe);
	}
}
