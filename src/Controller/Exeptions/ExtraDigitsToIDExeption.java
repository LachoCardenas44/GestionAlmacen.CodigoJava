package Controller.Exeptions;

public class ExtraDigitsToIDExeption extends Exception{

    public ExtraDigitsToIDExeption() {
        super("Too many digits");
    }

    public ExtraDigitsToIDExeption(String message) {
        super(message);
    }
    
}
