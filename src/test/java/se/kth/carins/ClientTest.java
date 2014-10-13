package se.kth.carins;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import se.kth.carins.Business.ClientFunc;
import se.kth.carins.Entities.Client;
import se.kth.carins.Entities.CustomerForm;

public class ClientTest {
	private static ClientFunc clientFunc;
	
	@BeforeClass
	public static void Before() {
		Client client = new Client("nikos", "anestos@kth.se", "4546", "licencePlate");
		clientFunc = new ClientFunc();
		clientFunc.addClient(client);
	}
	@Test
	public void testIsClient() {
		CustomerForm formData = new CustomerForm("nikos", "accidentDescription", "licencePlate", "anestos@kth.se", "customerPhone");
		CustomerForm wrongData = new CustomerForm("zzz", "zzz", "zzz", "zzz", "zzz");

		assertEquals(true, clientFunc.isClient(formData));
		assertEquals(false, clientFunc.isClient(wrongData));
	}

}
