package se.kth.carins;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import se.kth.carins.Business.ClaimFunc;
import se.kth.carins.Entities.Claim;
import se.kth.carins.Entities.Client;
import se.kth.carins.Entities.Employee;

public class ClaimTest {
	private static Claim claim0;
	private static Client client0;
	private static ClaimFunc claimFunc;
	
	@BeforeClass
	public static void Before() {
		claimFunc = new ClaimFunc();
		char[] pwd = {'1', '2', '3', '4'};
		Employee employee = new Employee("Michael", pwd, "finance");
		client0 = new Client("john", "john@mail.se", "4354", "yar3425", "10000");
		claim0 = new Claim("john", "crash", "yar3425", "0703485", "john@mail.se", employee);
		claim0.setCost(100f);
		client0.addClaimToHistory(claim0);
		claim0.setCategory("simple");
		claim0.setPaid();
		claimFunc.addClaim(claim0);
	}
	
	@Test
	public void testClaim() {
		assertEquals("john", claim0.getCustomerName());
		assertEquals("crash", claim0.getAccidentDesc());
		assertEquals("yar3425", claim0.getLicensePlate());
		assertEquals("0703485", claim0.getCustomerPhone());
		assertEquals("john@mail.se", claim0.getCustomerEmail());
		char[] pwd = { '1', '2', '3', '4'};
		assertArrayEquals(pwd, claim0.getEmployee().getPassword());
		assertEquals(100f, claim0.getCost(), 2);		
		assertEquals(true,claim0.getPaid());
		assertNotNull(claim0.getRegistrationDate());
		assertEquals("simple",claim0.getCategory());
	}
	@Test
	public void testClaimFunc(){
		assertNotEquals(0,claimFunc.getAllClaims().size());
		assertNotEquals(0,claimFunc.filterClaims().size());
		assertEquals(1 ,claimFunc.filterClaims("registered").size());
		assertNotNull(claimFunc.searchClaim("yar3425"));		
	}
	@Test
	public void testClaimFunc2(){
		assertEquals(1,claimFunc.getAllClaims().size());
		assertEquals(1,claimFunc.filterClaims().size());
		assertNotEquals(0 ,claimFunc.filterClaims("registered").size());
		assertNull(claimFunc.searchClaim("yar34a25"));		
	}
}
