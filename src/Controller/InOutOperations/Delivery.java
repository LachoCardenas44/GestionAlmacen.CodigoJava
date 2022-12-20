package Controller.InOutOperations;

import ProductsStock.*;

public class Delivery {

	private Product[] selledProducts;
	private double transportationCost;
	private String destinationCountry;
	private int tax;
	private int discount;

	/**
	 * 
	 * @param selledProducts
	 * @param transportationCost
	 * @param destinationCountry
	 */
	public Delivery(Product[] selledProducts, double transportationCost, String destinationCountry) {
		// TODO - implement Delivery.Delivery
		throw new UnsupportedOperationException();
	}

	public double BaseCost() {
		// TODO - implement Delivery.BaseCost
		throw new UnsupportedOperationException();
	}

	public Product[] getSelledProducts() {
		// TODO - implement Delivery.getSelledProducts
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param selledProducts
	 */
	public void setSelledProducts(Product[] selledProducts) {
		// TODO - implement Delivery.setSelledProducts
		throw new UnsupportedOperationException();
	}

	public double getTransportationCost() {
		return this.transportationCost;
	}

	/**
	 * 
	 * @param transportationCost
	 */
	public void setTransportationCost(double transportationCost) {
		this.transportationCost = transportationCost;
	}

	public String getDestinationCountry() {
		return this.destinationCountry;
	}

	/**
	 * 
	 * @param destinationCountry
	 */
	public void setDestinationCountry(String destinationCountry) {
		this.destinationCountry = destinationCountry;
	}

	public int getTax() {
		return this.tax;
	}

	/**
	 * 
	 * @param tax
	 */
	public void setTax(int tax) {
		this.tax = tax;
	}

	public int getDiscount() {
		return this.discount;
	}

	/**
	 * 
	 * @param discount
	 */
	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public double DeliveryCost() {
		// TODO - implement Delivery.DeliveryCost
		throw new UnsupportedOperationException();
	}

}