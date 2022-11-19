package ProductsStock;

public class QualityRecord {

	private boolean canBeSelled;
	private boolean canBeBought;
	private boolean canBeLoss;
	private String state;
	private String supplyMethod;
	private String supplyingMethod;

	/**
	 * 
	 * @param canBeSelled
	 * @param canBeBought
	 * @param canBeLoss
	 * @param state
	 * @param supplyMethod
	 * @param supplyingMethod
	 */
	public QualityRecord(boolean canBeSelled, boolean canBeBought, boolean canBeLoss, String state, String supplyMethod, String supplyingMethod) {
		// TODO - implement QualityRecord.QualityRecord
		throw new UnsupportedOperationException();
	}

	public boolean getCanBeSelled() {
		return this.canBeSelled;
	}

	/**
	 * 
	 * @param canBeSelled
	 */
	public void setCanBeSelled(boolean canBeSelled) {
		this.canBeSelled = canBeSelled;
	}

	public boolean getCanBeBought() {
		return this.canBeBought;
	}

	/**
	 * 
	 * @param canBeBought
	 */
	public void setCanBeBought(boolean canBeBought) {
		this.canBeBought = canBeBought;
	}

	public boolean getCanBeLoss() {
		return this.canBeLoss;
	}

	/**
	 * 
	 * @param canBeLoss
	 */
	public void setCanBeLoss(boolean canBeLoss) {
		this.canBeLoss = canBeLoss;
	}

	public String getState() {
		return this.state;
	}

	/**
	 * 
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}

	public String getSupplyMethod() {
		return this.supplyMethod;
	}

	/**
	 * 
	 * @param supplyMethod
	 */
	public void setSupplyMethod(String supplyMethod) {
		this.supplyMethod = supplyMethod;
	}

	public String getSupplyingMethod() {
		return this.supplyingMethod;
	}

	/**
	 * 
	 * @param supplyingMethod
	 */
	public void setSupplyingMethod(String supplyingMethod) {
		this.supplyingMethod = supplyingMethod;
	}

}