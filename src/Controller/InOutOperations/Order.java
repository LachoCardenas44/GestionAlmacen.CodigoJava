package Controller.InOutOperations;

import java.io.Serializable;

import Controller.ProductsStock.*;

public class Order implements Serializable{


	private Product product;
	private int minAmount;
	private int amount;
	private boolean validate;

	public Order(Product product,int amount,boolean validate){

        this.product=product;
        this.amount=amount;
		this.validate=validate;

    }

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getMinAmount() {
		return this.minAmount;
	}

	public void setMinAmount(int minAmount) {
		this.minAmount = minAmount;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	public boolean getValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}


	public double OrderCost() {
		
		return Integer.parseInt(product.getCost())*amount;
		

	}

}