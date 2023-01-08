package Controller.ExternalAgents;

import java.io.Serializable;

public class Supplier implements Serializable{

	private String name;
	private String id;

	public Supplier(String name, String id) {
		this.name=name;
		this.id=id;
		
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	
	

}