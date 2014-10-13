package se.kth.carins.Entities;

import java.util.Date;

public class Claim extends CustomerForm {
	//private Integer Id;
	private Float cost;
	private String status;
	private String category;
	private Employee employee;
	private Date registrationDate;
	
	public Claim(String customerName, String accidentDesc, String licensePlate, String customerPhone,
			String customerEmail, Employee employee) {
		super(customerName, accidentDesc, licensePlate, customerEmail, customerPhone);
		this.employee = employee;
		this.registrationDate = new Date();
		this.status = "Registered";
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Employee getEmployee() {
		return employee;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}
}