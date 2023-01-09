package Controller.Exeptions;

public class NotFoundAdminException extends Exception{

    public NotFoundAdminException() {
        super("You're not in the system");
    }

    public NotFoundAdminException(String message) {
        super(message);
    }
    
}
