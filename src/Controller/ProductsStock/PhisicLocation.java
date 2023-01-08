package Controller.ProductsStock;

import java.io.Serializable;

public class PhisicLocation implements Serializable{

	private String shelf;	
	private String hall;
	private String high;


	public PhisicLocation(String shelf,String hall,String high){
		this.hall=hall;
		this.high=high;
		this.shelf=shelf;
	}

	public String getHall() {
		return this.hall;
	}

	
	public void setHall(String hall) {
		this.hall = hall;
	}

	public String getHigh() {
		return this.high;
	}

	/**
	 * 
	 * @param high
	 */
	public void setHigh(String high) {
		this.high = high;
	}

	public String getShelf() {
		return shelf;
	}


	public void setShelf(String shelf) {
		this.shelf=shelf;
	}

}
