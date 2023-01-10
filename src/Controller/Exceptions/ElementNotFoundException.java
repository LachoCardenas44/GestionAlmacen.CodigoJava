package Controller.Exceptions;

public class ElementNotFoundException extends Exception{

	public ElementNotFoundException () {	
	
		super("Element not found");
	
	}
	
	public ElementNotFoundException (String message) {

		super(message);
	
	}

}
