package se.kth.carins.Business;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import se.kth.carins.Entities.Claim;
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
	
	public List<Claim> filterClaims() {
		List<Claim> result = new LinkedList<Claim>();
		Claim tmpClaim;
		Iterator<Claim> iter = claims.iterator();
		
		while(iter.hasNext()) {
			tmpClaim = iter.next();
			
			if (tmpClaim.getPaid()) {
				result.add(tmpClaim);
			}
		}
		return result;
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
