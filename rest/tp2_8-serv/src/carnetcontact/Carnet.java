package carnetcontact;

import java.util.*;


public class Carnet{
	private Collection<Contact> contacts;
	public Carnet() {
		super();
		this.contacts = new ArrayList<Contact>();
		this.initialize();
	}
	public void initialize(){
		this.contacts.add(new Contact("toto","0607080910"));
		this.contacts.add(new Contact("titi","0102030405"));
	}
	public String toString(){
		String string="";
		for (Contact contact : this.contacts) {
			string += "\n-----------------\n"
				   +  "nom : "+contact.getNom()
				   +  "\n"
				   +  "numero :"+contact.getNumero()
				   +  "\n-----------------\n";
		}
		return string;
	}
	public Contact getContactByName(String contactName){
		if("".equals(contactName)){
			return null;
		}else{
			for(Contact contact : this.contacts){
				if(contact.getNom().equals(contactName)){
					return contact;
				}
			}
		}
		return null;
	}
	public void setContact(Contact contactToAdd){
		String contactName = contactToAdd.getNom();
		if("".equals(contactName)){
			return ;
		}else{
			for(Contact contact : this.contacts){
				if(contact.getNom().equals(contactName)){
					contact = contactToAdd;
				}
			}
		}
	}
//----------------------------Collection decorator---------------------------------//
	public int size() {
		return this.contacts.size();
	}
	public boolean isEmpty() {
		return this.contacts.isEmpty();
	}
	public boolean contains(Contact o) {
		return this.contacts.contains(o);
	}
	public Iterator<Contact> iterator() {
		return this.contacts.iterator();
	}
	public boolean add(Contact e) {
		return this.contacts.add((Contact) e);
	}
	public boolean remove(Contact o) {
		return this.contacts.remove(o);
	}
	public void clear() {
		this.contacts.clear();
	}
//-------------------------------------------------------------------------------//
}