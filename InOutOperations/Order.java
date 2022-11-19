package InOutOperations;

import ProductsStock.*;

public class Order {

	private int deliveryTime;
	private Product product;
	private int minAmount;
	private int amount;
	private String date;

	/**
	 * 
	 * @param deliveryTime
	 * @param product
	 * @param minAmount
	 * @param amount
	 */
	public Order(int deliveryTime, Product product, int minAmount, int amount) {
		// TODO - implement Order.Order
		throw new UnsupportedOperationException();
	}

	public int getDeliveryTime() {
		return this.deliveryTime;
	}

	/**
	 * 
	 * @param deliveryTime
	 */
	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public Product getProduct() {
		return this.product;
	}

	/**
	 * 
	 * @param product
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	public int getMinAmount() {
		return this.minAmount;
	}

	/**
	 * 
	 * @param minAmount
	 */
	public void setMinAmount(int minAmount) {
		this.minAmount = minAmount;
	}

	public int getAmount() {
		return this.amount;
	}

	/**
	 * 
	 * @param amount
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDate() {
		return this.date;
	}

	/**
	 * 
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	public double OrderCost() {
		// TODO - implement Order.OrderCost
		throw new UnsupportedOperationException();
	}

	public double TotalOrderCost() {
		// TODO - implement Order.TotalOrderCost
		throw new UnsupportedOperationException();
	}

}