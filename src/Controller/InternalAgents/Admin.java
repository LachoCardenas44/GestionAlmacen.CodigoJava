package Controller.InternalAgents;

import java.io.Serializable;

public class Admin implements Serializable{
    
    private String name;
    private String password;

    /**
     * 
     */
    public Admin() {
        
    }

    /**
     * @param name
     * @param password
     */
    public Admin(String name ,String password){

        this.name=name;
        this.password=password;
        
    }
    
    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public void setPassword(String password){
        this.password=password;
    }
    
    public String getPassword(){
        return password;
    }
    
}