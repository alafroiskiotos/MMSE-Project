package se.kth.carins.storage;

import java.util.LinkedList;
import java.util.List;

import se.kth.carins.Entities.CustomerForm;
import se.kth.carins.Entities.Employee;

public class Storage {
	private static List<Employee> systemUsers;
	private static List<CustomerForm> customerForms;
	
	private static Storage storageInstance = null;
	
	public Storage() {
		systemUsers = new LinkedList<Employee>();
		customerForms = new LinkedList<CustomerForm>();
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
}
