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
	private static CustomerForm formData;
	private static CustomerForm wrongData;
	
	@BeforeClass
	public static void Before() {
		client = new Client("nikos", "anestos@kth.se", "0703485", "licencePlate");
		clientFunc = new ClientFunc();
		clientFunc.addClient(client);
		
		char[] pwd = { '1', '2', '3', '4'};
		Employee employee = new Employee("Michael", pwd, "finance");
		claim0 = new Claim("nikos", "crash", "licencePlate", "0703485", "anestos@kth.se", employee);
		claim0.setCategory("complex");
		
		formData = new CustomerForm("nikos", "accidentDescription", "licencePlate", "anestos@kth.se", "0703485");
		wrongData = new CustomerForm("zzz", "zzz", "zzz", "zzz", "zzz");
	}
	@Test
	public void testClientEntity(){
		assertEquals("nikos", client.getName());
		assertEquals("anestos@kth.se", client.getEmail());
		assertEquals("0703485", client.getPhone());
		assertEquals("licencePlate", client.getLicensePlate());
	}
	@Test
	public void testClientEntity2(){
		assertEquals(0,client.getClaimHistory().size());
		assertEquals(new Integer(0), clientFunc.hasHistory(client));
		assertFalse(clientFunc.hasRegisteredClaim(formData));
		
		client.addClaimToHistory(claim0);
		assertEquals(1,client.getClaimHistory().size());
		assertEquals(new Integer(1), clientFunc.hasHistory(client));
		assertTrue(clientFunc.hasRegisteredClaim(formData));
	}
	@Test
	public void testClient3(){
		assertNotNull(clientFunc.getClient("nikos","licencePlate"));
		assertNull(clientFunc.getClient("wrong","wrong"));
		assertNotNull(clientFunc.searchClient("nikos"));
		assertNotNull(clientFunc.searchClient("licencePlate"));
		assertNotNull(clientFunc.searchClient("0703485"));
		assertNotNull(clientFunc.searchClient("anestos@kth.se"));
		assertNull(clientFunc.searchClient("wrong"));
	
	}
	@Test
	public void testClaimCategory() {
		assertEquals("complex", claim0.getCategory());
	}
	@Test
	public void testIsClient() {
		
		assertEquals(true, clientFunc.isClient(formData));
		assertEquals(false, clientFunc.isClient(wrongData));
	}

}
