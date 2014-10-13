package se.kth.carins.Business;

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
}
