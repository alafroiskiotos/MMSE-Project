package se.kth.carins.Business;

import java.util.List;

import se.kth.carins.Entities.CustomerForm;
import se.kth.carins.storage.Storage;

public class CustomerFormFunc {
	private List<CustomerForm> customerForms;
	
	public CustomerFormFunc() {
		Storage storageInstance = Storage.getStorageInstance();
		customerForms = storageInstance.getCustomerForms();
	}
	
	public void addCustomerForm(CustomerForm customerForm){
		customerForms.add(customerForm);
	}
	
	public void removeCustomerForm(CustomerForm customerForm){
		customerForms.remove(customerForm);
	}
	
	public List<CustomerForm> getCustomerForms() {
		return customerForms;
	}
}
