package Controller.Exceptions;

public class NotFoundAdminException extends ElementNotFoundException{

    public NotFoundAdminException() {
        super("You're not in the system");
    }

    public NotFoundAdminException(String message) {
        super(message);
    }
    
}
