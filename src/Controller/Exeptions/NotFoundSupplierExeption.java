package Controller.Exeptions;

public class NotFoundSupplierExeption extends Exception{

    public NotFoundSupplierExeption() {
        super("The Supplier doesn't exist");
    }

    public NotFoundSupplierExeption(String message) {
        super(message);
    }
    
}
