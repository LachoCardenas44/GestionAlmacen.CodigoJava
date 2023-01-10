package Controller.WareHouse;

import java.io.Serializable;
import Controller.ExternalAgents.*;
import Controller.InternalAgents.Admin;

public class WareHouse implements Serializable{

    private String name;
    private Admin admin;
    private String address;

    public WareHouse (String name,String address,Admin admin) {
        this.name=name;
        this.address=address;
        this.admin=admin;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public String getAddress(){
        return address;
    }
    public void setAdmin(Admin admin){
        this.admin=admin;
    }
    public Admin getAdmin(){
        return admin;
    }
    public String toString(){
        return "Name : "+name+"\nAddress : "+address+"\nAdmin : "+admin.getName();
    }
    
}
