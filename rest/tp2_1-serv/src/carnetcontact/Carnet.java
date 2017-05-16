package carnetcontact;

import java.util.*;


public class Carnet implements Collection{
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
//----------------------------Collection decorator---------------------------------//
	@Override
	public int size() {
		return this.contacts.size();
	}
	@Override
	public boolean isEmpty() {
		return this.contacts.isEmpty();
	}
	@Override
	public boolean contains(Object o) {
		return this.contacts.contains(o);
	}
	@Override
	public Iterator<Contact> iterator() {
		return this.contacts.iterator();
	}
	@Override
	public Object[] toArray() {
		return this.contacts.toArray();
	}
	@Override
	public Object[] toArray(Object[] a) {
		return this.contacts.toArray(a);
	}
	@Override
	public boolean add(Object e) {
		return this.contacts.add((Contact) e);
	}
	@Override
	public boolean remove(Object o) {
		return this.contacts.remove(o);
	}
	@Override
	public boolean containsAll(Collection c) {
		return this.contacts.containsAll(c);
	}
	@Override
	public boolean addAll(Collection c) {
		return this.contacts.addAll(c);
	}
	@Override
	public boolean removeAll(Collection c) {
		return this.contacts.removeAll(c);
	}
	@Override
	public boolean retainAll(Collection c) {
		return this.contacts.retainAll(c);

	}
	@Override
	public void clear() {
		this.contacts.clear();
	}
//-------------------------------------------------------------------------------//
}