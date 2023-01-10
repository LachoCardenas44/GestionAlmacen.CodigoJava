package Controller.Exceptions;

public class ExtraDigitsToIDException extends Exception{

    public ExtraDigitsToIDException() {
        super("Too many digits");
    }

    public ExtraDigitsToIDException(String message) {
        super(message);
    }
    
}
