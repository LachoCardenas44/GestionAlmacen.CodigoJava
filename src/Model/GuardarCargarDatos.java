package Model;
//////////////////
import java.io.*;
import java.util.ArrayList;

public class GuardarCargarDatos {  
   
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static <E> void Guardar (ArrayList<E> objetos,String path) throws FileNotFoundException,IOException{
        
        File route = new File(path);
        FileOutputStream saveFile = new FileOutputStream(route);
        ObjectOutputStream saveData = new ObjectOutputStream(saveFile);
        int amount = objetos.size();
        saveData.writeInt(amount);
    
    for(int i=0;i<amount;i++){
        saveData.writeObject(objetos.get(i));
        
    }
    saveData.close();
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static <E> ArrayList<E> Cargar(String path) throws ClassNotFoundException,IOException {
        File route = new File(path);
        FileInputStream loadFile = new FileInputStream(route);
        ObjectInputStream loadData = new ObjectInputStream(loadFile);

        

        ArrayList<E> objetos = new ArrayList<E>();
        
        int amount = loadData.readInt();

        for(int i = 0;i<amount;i++){
            E newUser = (E)loadData.readObject();
            objetos.add(newUser);
        }
       
       loadData.close();
        return objetos;

    }
    ////////////////////////////////////////////////////////////////////////////////
    public static<E> ArrayList<E> LoadObject(ArrayList<E> objects,String path){
        try{
            objects = GuardarCargarDatos.Cargar(path);
        }catch(FileNotFoundException g1){
            objects = new ArrayList<>();
            System.out.println("Emptyness");
        }catch(IOException g2){
            objects = new ArrayList<>();
            System.out.println(g2.getMessage());
        }catch(ClassNotFoundException g3){
            objects = new ArrayList<>();
            System.out.println(g3.getMessage());
        }
        return objects;
    }
    /////////////////////////////////////////////////////////////////////////////////////
    public static <E> void SaveObject(ArrayList<E> objects,String path){
        try{
            GuardarCargarDatos.Guardar(objects, path);
        }catch(IOException g){
            System.out.println(g.getMessage());
        }    
    }
}
