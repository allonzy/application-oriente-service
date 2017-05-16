package carnetcontact;
@XmlRootElement
public class Contact {
	private String nom;
	private String numero;
	public Contact() {
		super();
	}
	public Contact(String nom, String numero) {
		super();
		this.nom = nom;
		this.numero = numero;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
}
