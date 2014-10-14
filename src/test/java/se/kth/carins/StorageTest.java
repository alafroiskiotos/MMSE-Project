package se.kth.carins;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import se.kth.carins.Business.ClaimFunc;
import se.kth.carins.Business.ClientFunc;
import se.kth.carins.Business.CustomerFormFunc;
import se.kth.carins.Business.UsersFunc;
import se.kth.carins.Entities.Claim;
import se.kth.carins.Entities.Client;
import se.kth.carins.Entities.CustomerForm;
import se.kth.carins.Entities.Employee;
import se.kth.carins.storage.Storage;

public class StorageTest {
	private static Storage storageInstance;
	private static CustomerFormFunc formFunc;
	private static UsersFunc userFunc;
	private static ClientFunc clientFunc;
	private static ClaimFunc claimFunc;
	
	@BeforeClass
	public static void Before() {
		storageInstance = Storage.getStorageInstance();
		formFunc = new CustomerFormFunc();
		userFunc = new UsersFunc();
		clientFunc = new ClientFunc();
		claimFunc = new ClaimFunc();
	}
	
	@Test
	public void testStorageEmpty() {
		assertEquals(0, storageInstance.getCustomerForms().size());
		assertEquals(0,  storageInstance.getClaims().size());
		assertEquals(0, storageInstance.getClients().size());
		assertEquals(0, storageInstance.getSystemUsersList().size());

		CustomerForm formData = new CustomerForm("nikos", "accidentDescription", "licencePlate", "anestos@kth.se", "customerPhone");
		formFunc.addCustomerForm(formData);
		assertEquals(1, storageInstance.getCustomerForms().size());
		
		char[] pwd = { '1', '2', '3', '4'};
		Employee employee = new Employee("nikos", pwd, "finance");
		userFunc.addUser(employee);
		assertEquals(1, storageInstance.getSystemUsersList().size());

		Client client = new Client("nikos","anestos@kth.se","customerPhone", "licencePlate");
		clientFunc.addClient(client);
		assertEquals(1, storageInstance.getClients().size());
		
		Claim claim = new Claim("nikos","description","licencePlate","customerPhone","anestos@kth.se",employee);
		claimFunc.addClaim(claim);
		assertEquals(1, storageInstance.getClaims().size());
	}
}
