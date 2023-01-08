package Controller.ExternalAgents;

public class ExternalAgent {
	
	
	protected String name;
	protected String phoneNumber;
	protected String address;
	protected int id;
	protected String email;
	protected String funtion;

	
	public ExternalAgent(String name, String phoneNumber, String address, int id, String email, String funtion) {
		this.name=name;
		this.phoneNumber=phoneNumber;
		this.address=address;
		this.id=id;
		this.email=email;
		this.funtion=funtion;
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

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	/**
	 * 
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
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