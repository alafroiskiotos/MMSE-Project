package se.kth.carins.Business;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import se.kth.carins.Entities.Claim;
import se.kth.carins.storage.Storage;

public class ClaimFunc {
	private List<Claim> claims;
	private Iterator<Claim> iterator;
	private Claim tmpClaim;
	private List<Claim> result;
	
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
		result = new LinkedList<Claim>();
		iterator = claims.iterator();
		
		while(iterator.hasNext()) {
			tmpClaim = iterator.next();
			
			if (status.equals(tmpClaim.getStatus())) {
				result.add(tmpClaim);
			}
		}
		
		iterator = null;
		tmpClaim = null;
		
		return result;
	}
	
	public List<Claim> filterClaims() {
		result = new LinkedList<Claim>();
		iterator = claims.iterator();
		
		while(iterator.hasNext()) {
			tmpClaim = iterator.next();
			
			if (tmpClaim.getPaid()) {
				result.add(tmpClaim);
			}
		}
		iterator = null;
		tmpClaim = null;
		
		return result;
	}
		
	
	public Claim searchClaim(String licencePlate) {
		Claim result = null;
		iterator = claims.iterator();
		
		while(iterator.hasNext()) {
			tmpClaim = iterator.next();
			
			if (licencePlate.equals(tmpClaim.getLicensePlate())) {
				result = tmpClaim;
			}
		}
		iterator = null;
		tmpClaim = null;
		
		return result;
	}
}
