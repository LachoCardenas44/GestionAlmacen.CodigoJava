package Controller.Exeptions;

public class EmptyFieldsExeption extends Exception{
    

    public EmptyFieldsExeption() {
        super("Fill all the fields");
    }

    public EmptyFieldsExeption(String message) {
        super(message);
    }


    
}
