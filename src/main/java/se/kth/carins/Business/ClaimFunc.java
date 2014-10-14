package se.kth.carins.Business;

import java.util.Iterator;
import java.util.LinkedList;
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
	
	public List<Claim> filterClaims(String status) {
		List<Claim> result = new LinkedList<Claim>();
		Claim tmpClaim;
		Iterator<Claim> iter = claims.iterator();
		
		while(iter.hasNext()) {
			tmpClaim = iter.next();
			
			if (status.equals(tmpClaim.getStatus())) {
				result.add(tmpClaim);
			}
		}

		return result;
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
	
	public Claim searchClaim(String licencePlate) {
		Claim result = null;
		Claim tmpClaim;
		Iterator<Claim> iter = claims.iterator();
		
		while(iter.hasNext()) {
			tmpClaim = iter.next();
			
			if (licencePlate.equals(tmpClaim.getLicensePlate())) {
				result = tmpClaim;
			}
		}

		return result;
	}
}
