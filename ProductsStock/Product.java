package ProductsStock;

import ExternalAgents.*;

public class Product {

	private String name;
	private PhisicLocation phisicLocation;
	private String category;
	private StockRecord stockRecord;
	private QualityRecord qualityRecord;
	private double sellPrice;
	private double cost;
	private String basePrice;
	private Supplier supplier;

	/**
	 * 
	 * @param name
	 * @param phisicLocation
	 * @param category
	 * @param stockRecord
	 * @param qualityRecord
	 */
	public Product(String name, PhisicLocation phisicLocation, String category, StockRecord stockRecord, QualityRecord qualityRecord) {
		// TODO - implement Product.Product
		throw new UnsupportedOperationException();
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public PhisicLocation getPhisicLocation() {
		// TODO - implement Product.getPhisicLocation
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param phisicLocation
	 */
	public void setPhisicLocation(PhisicLocation phisicLocation) {
		// TODO - implement Product.setPhisicLocation
		throw new UnsupportedOperationException();
	}

	public String getCategory() {
		return this.category;
	}

	/**
	 * 
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	public StockRecord getStockRecord() {
		return this.stockRecord;
	}

	/**
	 * 
	 * @param stockRecord
	 */
	public void setStockRecord(StockRecord stockRecord) {
		this.stockRecord = stockRecord;
	}

	public QualityRecord getQualityRecord() {
		return this.qualityRecord;
	}

	/**
	 * 
	 * @param qualityRecord
	 */
	public void setQualityRecord(QualityRecord qualityRecord) {
		this.qualityRecord = qualityRecord;
	}

	public double getSellPrice() {
		return this.sellPrice;
	}

	/**
	 * 
	 * @param sellPrice
	 */
	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public double getCost() {
		return this.cost;
	}

	/**
	 * 
	 * @param cost
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getBasePrice() {
		return this.basePrice;
	}

	/**
	 * 
	 * @param basePrice
	 */
	public void setBasePrice(String basePrice) {
		this.basePrice = basePrice;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	/**
	 * 
	 * @param supplier
	 */
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

}