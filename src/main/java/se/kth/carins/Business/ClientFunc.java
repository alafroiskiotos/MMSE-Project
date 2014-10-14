package se.kth.carins.Business;

import java.util.Iterator;
import java.util.List;

import se.kth.carins.Entities.Claim;
import se.kth.carins.Entities.Client;
import se.kth.carins.Entities.CustomerForm;
import se.kth.carins.storage.Storage;

public class ClientFunc {
	private List<Client> clients;
	private Iterator<Client> iterator;
	private Client result = null;
	private Boolean resultBool = false;
	
	public ClientFunc() {
		Storage storageInstance = Storage.getStorageInstance();
		clients = storageInstance.getClients();
	}
	
	public void addClient(Client client) {
		clients.add(client);
	}
	
	public Integer hasHistory(Client client) {
		List<Claim> claims = client.getClaimHistory();
		Integer history;
		if (claims == null)
			history = 0;
		else
			history = claims.size();
		return history;
	}
	
	public Client getClient(String name, String licencePlate) {
		Client tmpClient;
		result = null;
		iterator = null;
		iterator = clients.iterator();
		
		while(iterator.hasNext()) {
			tmpClient = iterator.next();
			
			if (name.equals(tmpClient.getName()) && licencePlate.equals(tmpClient.getLicensePlate())) {
				result = tmpClient;
			}
		}
		iterator = null;
		
		return result;
	}
	
	public Client searchClient(String query) {
		Client tmpClient;
		iterator = null;
		result = null;
		iterator = clients.iterator();
		
		while(iterator.hasNext()) {
			tmpClient = iterator.next();
			
			if (query.equals(tmpClient.getName()) || query.equals(tmpClient.getLicensePlate()) || query.equals(tmpClient.getEmail()) || query.equals(tmpClient.getPhone())) {
				result = tmpClient;
			}
		}
		iterator = null;
		
		return result;
	}

	public boolean hasRegisteredClaim(CustomerForm form) {
		String name = form.getCustomerName();
		String licencePlate = form.getLicensePlate();
		resultBool = false;
		Claim tmpClaim;
		List<Claim> claims = getClient(name,licencePlate).getClaimHistory();
		Iterator<Claim> iter = claims.iterator();
		
		while(iter.hasNext()) {
			tmpClaim = iter.next();
			if (new String("registered").equals(tmpClaim.getStatus())) {
				resultBool = true;
				break;
			}
		}
		return resultBool;
	}
	
	public boolean isClient(CustomerForm form) {
		String name = form.getCustomerName();
		String email = form.getCustomerEmail();
		String licensePlate = form.getLicensePlate();
		resultBool = false;
		iterator = null;
		Client tmpClient;
		
		iterator = clients.iterator();
		
		while(iterator.hasNext()) {
			tmpClient = iterator.next();
			if (name.equals(tmpClient.getName()) && email.equals(tmpClient.getEmail()) &&
					licensePlate.equals(tmpClient.getLicensePlate())) {
				resultBool = true;
				break;
			}
		}
		iterator = null;
		
		return resultBool;
	}
}
