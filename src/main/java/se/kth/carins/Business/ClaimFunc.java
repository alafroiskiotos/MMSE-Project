package se.kth.carins.Business;

import java.util.List;

import se.kth.carins.Entities.Claim;
import se.kth.carins.Entities.Client;
import se.kth.carins.storage.Storage;

public class ClaimFunc {
	private List<Claim> claims;
	
	public ClaimFunc() {
		Storage storageInstance = Storage.getStorageInstance();
		claims = storageInstance.getClaims();
	}
	
	public void addClaim(Claim claim) {
		claims.add(claim);
	}
	
	public List<Claim> getAllClaims() {
		return claims;
	}
	
	public void categorize(Claim claim) {
		String name = claim.getCustomerName();
		System.out.println(name);
		String licencePlate = claim.getLicensePlate();
		System.out.println(licencePlate);
		ClientFunc clientFunc = new ClientFunc();
		Client client = clientFunc.getClient(name, licencePlate);
		System.out.println(clientFunc.hasHistory(client));
		
		if (clientFunc.hasHistory(client) > 0)
			claim.setCategory("complex");
		else
			claim.setCategory("simple");
	}
	
	public void updateStatus(Claim claim, String status) {
		claim.setStatus(status);
	}
}
