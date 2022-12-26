package Controller.ExternalAgents;

public class ExternalAgent {
	
	
	protected String name;
	protected int phoneNumber;
	protected String address;
	protected int id;
	protected String email;
	protected String funtion;

	/**
	 * 
	 * @param name
	 * @param phoneNumber
	 * @param adress
	 * @param id
	 * @param email
	 * @param funtion
	 */
	public ExternalAgent(String name, String phoneNumber, String adress, int id, String email, String funtion) {
		// TODO - implement ExternalAgent.ExternalAgent
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

	public int getPhoneNumber() {
		return this.phoneNumber;
	}

	/**
	 * 
	 * @param phoneNumber
	 */
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return this.address;
	}

	/**
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	public int getId() {
		return this.id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String getFuntion() {
		return this.funtion;
	}

	/**
	 * 
	 * @param funtion
	 */
	public void setFuntion(String funtion) {
		this.funtion = funtion;
	}

}