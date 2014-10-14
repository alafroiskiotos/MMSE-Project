package se.kth.carins.Business;

public class Communication {
	
	public String informGarage(String LicencePlate) {
		String reply = "Sent Email to Garage about car with licence plate: " + LicencePlate;
		return reply;
	}

}
