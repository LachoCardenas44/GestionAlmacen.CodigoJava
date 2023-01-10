package Controller.Exceptions;

public class NotFoundSupplierException extends ElementNotFoundException{

    public NotFoundSupplierException() {
        super("The Supplier doesn't exist");
    }

    public NotFoundSupplierException(String message) {
        super(message);
    }
    
}
