package se.kth.carins;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import se.kth.carins.Business.ClientFunc;
import se.kth.carins.Entities.Claim;
import se.kth.carins.Entities.Client;
import se.kth.carins.Entities.CustomerForm;
import se.kth.carins.Entities.Employee;

public class ClientTest {
	private static ClientFunc clientFunc;
	private static Claim claim0;
	private static Client client;
	
	@BeforeClass
	public static void Before() {
		client = new Client("nikos", "anestos@kth.se", "4546", "licencePlate");
		clientFunc = new ClientFunc();
		clientFunc.addClient(client);
		
		char[] pwd = { '1', '2', '3', '4'};
		Employee employee = new Employee("Michael", pwd, "finance");
		
		claim0 = new Claim("nikos", "crash", "licencePlate", "0703485", "john@mail.se", employee);
		
		Client client0 = clientFunc.getClient(claim0.getCustomerName(), claim0.getLicensePlate());
		client0.addClaimToHistory(claim0);
		if (clientFunc.hasHistory(client0) > 0)
			claim0.setCategory("complex");
		else
			claim0.setCategory("simple");
	}
	
	@Test
	public void testHistory(){
		assertEquals(new Integer(1), clientFunc.hasHistory(client));
	}
	@Test
	public void testClaimCategory() {
		assertEquals("complex", claim0.getCategory());
	}
	@Test
	public void testIsClient() {
		CustomerForm formData = new CustomerForm("nikos", "accidentDescription", "licencePlate", "anestos@kth.se", "customerPhone");
		CustomerForm wrongData = new CustomerForm("zzz", "zzz", "zzz", "zzz", "zzz");

		assertEquals(true, clientFunc.isClient(formData));
		assertEquals(false, clientFunc.isClient(wrongData));
	}

}
