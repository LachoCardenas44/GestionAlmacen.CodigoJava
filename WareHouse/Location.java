package WareHouse;

public class Location {

	private String name;
	private String locationType;
	private String chainedLocationType;
	private String chainedType;

	public Location() {
		// TODO - implement Location.Location
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 * @param chainedLocationType
	 * @param chainedType
	 */
	public Location(String name, String chainedLocationType, String chainedType) {
		// TODO - implement Location.Location
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

	public String getLocationType() {
		return this.locationType;
	}

	/**
	 * 
	 * @param locationType
	 */
	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	public String getChainedLocationType() {
		return this.chainedLocationType;
	}

	/**
	 * 
	 * @param chainedLocationType
	 */
	public void setChainedLocationType(String chainedLocationType) {
		this.chainedLocationType = chainedLocationType;
	}

	public String getChainedType() {
		return this.chainedType;
	}

	/**
	 * 
	 * @param chainedType
	 */
	public void setChainedType(String chainedType) {
		this.chainedType = chainedType;
	}

}