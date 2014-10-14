package se.kth.carins;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import se.kth.carins.Business.Communication;

public class CommunicationTest {
	private static Communication com;
	@BeforeClass
	public static void before() {
		com = new Communication();
	}
	@Test
	public void test() {
		assertEquals("Sent Email to Garage about car with licence plate: LicencePlate" , com.informGarage("LicencePlate"));

	}

}
