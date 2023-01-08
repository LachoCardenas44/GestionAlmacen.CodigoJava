package Controller.ProductsStock;

import java.io.Serializable;

import Controller.ExternalAgents.Supplier;

public class Product implements Serializable{

	private String name;
	private PhisicLocation phisicLocation;	
	private String productType;	
	private String sellPrice;
	private String cost;
	private String supplier;

	
	public Product(String name, PhisicLocation phisicLocation,String supplier, String productType, String sellPrice, String cost) {
		
		this.name=name;
		this.phisicLocation=phisicLocation;
		this.supplier=supplier;
		this.productType=productType;		
		this.cost=cost;
		this.sellPrice=sellPrice;
		

	}

	public String getName() {

		return name;
		
	}
	public void setName(String name) {

		this.name = name;

	}

	public PhisicLocation getPhisicLocation() {

		return phisicLocation;

	}
	public void setPhisicLocation(PhisicLocation phisicLocation) {

		this.phisicLocation=phisicLocation;

	}
	
	public String getProductType() {

		return this.productType;

	}
	public void setProductType(String productType) {

		this.productType = productType;

	}	

	public String getSellPrice() {

		return this.sellPrice;

}
	public void setSellPrice(String sellPrice) {

		this.sellPrice = sellPrice;

	}

	public String getCost() {

		return this.cost;

	}
	public void setCost(String cost) {

		this.cost = cost;

	}

	public String getSupplier() {

		return this.supplier;

	}
	public void setSupplier(String supplier) {

		this.supplier = supplier;
		
	}

}