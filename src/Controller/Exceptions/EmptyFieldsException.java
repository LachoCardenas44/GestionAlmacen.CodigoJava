package Controller.Exceptions;

public class EmptyFieldsException extends Exception{
    

    public EmptyFieldsException() {
        super("Fill all the fields");
    }

    public EmptyFieldsException(String message) {
        super(message);
    }


    
}
