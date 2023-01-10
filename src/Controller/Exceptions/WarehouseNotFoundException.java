package Controller.Exceptions;

public class WarehouseNotFoundException extends ElementNotFoundException{

	public WarehouseNotFoundException () {	
	
		super("Warehouse not found");
	
	}
	
	public WarehouseNotFoundException (String message) {

		super(message);
	
	}

}