package hello;

import java.io.IOException;

import javax.ws.rs.client.*;
import javax.ws.rs.core.*;
import javax.xml.parsers.*;

import org.glassfish.jersey.client.ClientConfig;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class HelloClient {
	public static void main(String[] args) {
		try{
			DocumentBuilder docBuilder = DocumentBuilderFactory
					.newInstance()
					.newDocumentBuilder();
			ClientConfig config= new ClientConfig();
			Client client = ClientBuilder.newClient(config);
			WebTarget webTarget = client.target(
					UriBuilder
					.fromUri("http://localhost:8080/HelloWorldService/")
					.build()
				);
			Document helloDoc = docBuilder.parse(
					webTarget.path("hello")
					.request()
					.accept(MediaType.APPLICATION_XML)
					.get(String.class)
				);
			String hello = helloDoc.getTextContent();
			System.out.println(hello);
		}catch(SAXException e1){
			e1.printStackTrace();
		}catch(IOException e2){
			e2.printStackTrace();
		}catch(ParserConfigurationException e3){
			e3.printStackTrace();
		}
	}
}
