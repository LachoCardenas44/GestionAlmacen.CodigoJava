package Controller.Exeptions;

public class FiewDigitsToIDExeption extends Exception{

    public FiewDigitsToIDExeption() {
        super("Need more digits");
    }

    public FiewDigitsToIDExeption(String message) {
        super(message);
    }
    
}
