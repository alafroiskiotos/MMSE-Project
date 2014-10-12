package se.kth.carins.Entities;

public class CustomerForm {
	private String customerName;
	private String accidentDesc;
	private String licensePlate;
	private String customerPhone;
	private String customerEmail;
	
	public CustomerForm(String customerName, String accidentDesc, String licensePlate, String customerEmail, String customerPhone) {
		this.customerName = customerName;
		this.accidentDesc = accidentDesc;
		this.licensePlate = licensePlate;
		this.customerPhone = customerPhone;
		this.customerEmail = customerEmail;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getAccidentDesc() {
		return accidentDesc;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}
}
