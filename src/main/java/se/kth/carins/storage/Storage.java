package se.kth.carins.storage;

import java.util.LinkedList;
import java.util.List;

import se.kth.carins.Entities.Claim;
import se.kth.carins.Entities.Client;
import se.kth.carins.Entities.CustomerForm;
import se.kth.carins.Entities.Employee;

public class Storage {
	private static List<Employee> systemUsers;
	private static List<CustomerForm> customerForms;
	private static List<Claim> claims;
	private static List<Client> clients;
	
	private static Storage storageInstance = null;
	
	public Storage() {
		systemUsers = new LinkedList<Employee>();
		customerForms = new LinkedList<CustomerForm>();
		claims = new LinkedList<Claim>();
		clients = new LinkedList<Client>();
	}
	
	public static Storage getStorageInstance() {
		if (storageInstance == null) {
			storageInstance = new Storage();
		}
		
		return storageInstance;
	}
	
	
	public static List<Employee> getSystemUsersList() {
		return systemUsers;
	}
	public static List<CustomerForm> getCustomerForms() {
		return customerForms;
	}
	public static List<Claim> getClaims() {
		return claims;
	}
	public static List<Client> getClients() {
		return clients;
	}
}
