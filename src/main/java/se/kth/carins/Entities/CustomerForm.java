package se.kth.carins.Entities;

public class CustomerForm {
	private String customerName;
	private String accidentDesc;
	private String licensePlate;
	
	public CustomerForm(String customerName, String accidentDesc, String licensePlate) {
		this.customerName = customerName;
		this.accidentDesc = accidentDesc;
		this.licensePlate = licensePlate;
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
}
