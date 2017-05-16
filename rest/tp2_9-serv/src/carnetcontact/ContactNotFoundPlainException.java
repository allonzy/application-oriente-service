package carnetcontact;

import java.util.*;
public class ContactNotFoundPlainException extends Exception{
	private static final long serialVersionUID = 1L;
	public ContactNotFoundPlainException(){
		super("Contact inconnu");
	}
}