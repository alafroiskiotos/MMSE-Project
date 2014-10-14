package se.kth.carins.Entities;

import java.util.LinkedList;
import java.util.List;

public class Client {
	private String name;
	private String email;
	private String phone;
	private String licensePlate;
	private String carValue;
	private List<Claim> claimHistory;
	
	public Client(String name, String email, String phone, String licensePlate, String carValue) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.carValue = carValue;
		this.licensePlate = licensePlate;
		claimHistory = new LinkedList<Claim>();
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getCarValue() {
		return carValue;
	}
	
	public String getLicensePlate() {
		return licensePlate;
	}
	
	public void addClaimToHistory(Claim claim) {
		claimHistory.add(claim);
	}
	
	public List<Claim> getClaimHistory() {
		return claimHistory;
	}
}