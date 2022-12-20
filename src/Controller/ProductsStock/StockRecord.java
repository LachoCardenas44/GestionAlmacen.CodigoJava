package Controller.ProductsStock;

public class StockRecord {

	private int realStock;
	private int virtualStock;
	private String productType;
	private int minStockRule;
	private int maxStockRule;
	private String measureUnit;

	/**
	 * 
	 * @param realStock
	 * @param virtualStock
	 * @param productType
	 * @param minStockRule
	 * @param maxStockRule
	 * @param measureUnit
	 */
	public StockRecord(int realStock, int virtualStock, String productType, int minStockRule, int maxStockRule, String measureUnit) {
		// TODO - implement StockRecord.StockRecord
		throw new UnsupportedOperationException();
	}

	public int getRealStock() {
		return this.realStock;
	}

	/**
	 * 
	 * @param realStock
	 */
	public void setRealStock(int realStock) {
		this.realStock = realStock;
	}

	public int getVirtualStock() {
		return this.virtualStock;
	}

	/**
	 * 
	 * @param virtualStock
	 */
	public void setVirtualStock(int virtualStock) {
		this.virtualStock = virtualStock;
	}

	public void getProductType() {
		// TODO - implement StockRecord.getProductType
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param productType
	 */
	public void setProductType(int productType) {
		// TODO - implement StockRecord.setProductType
		throw new UnsupportedOperationException();
	}

	public int getMinStockRule() {
		return this.minStockRule;
	}

	/**
	 * 
	 * @param minStockRule
	 */
	public void setMinStockRule(int minStockRule) {
		this.minStockRule = minStockRule;
	}

	public int getMaxStockRule() {
		return this.maxStockRule;
	}

	/**
	 * 
	 * @param maxStockRule
	 */
	public void setMaxStockRule(int maxStockRule) {
		this.maxStockRule = maxStockRule;
	}

	public StockRecord() {
		// TODO - implement StockRecord.StockRecord
		throw new UnsupportedOperationException();
	}

	public String getMeditionUnit() {
		// TODO - implement StockRecord.getMeditionUnit
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param meditionUnit
	 */
	public void setMeditionUnit(String meditionUnit) {
		// TODO - implement StockRecord.setMeditionUnit
		throw new UnsupportedOperationException();
	}

}