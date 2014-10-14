package se.kth.carins;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import se.kth.carins.Business.CustomerFormFunc;
import se.kth.carins.Entities.CustomerForm;

public class CustomerFormTest {
	private static CustomerForm form0;
	private static CustomerForm form1;
	private static CustomerFormFunc customerFormFunc;
	
	@BeforeClass
	public static void Before() {
		form0 = new CustomerForm("name", "accident", "iet4583", "test@email.se", "078181818");
		customerFormFunc = new CustomerFormFunc();
		customerFormFunc.addCustomerForm(form0);
		form1 = new CustomerForm("anetos", "drunk", "oet2345", "test@email.se", "078181818");
		customerFormFunc.addCustomerForm(form1);
	}
	
	@Test
	public void testgetCustomerForms() {
		List<CustomerForm> customerForms = customerFormFunc.getCustomerForms();
		assertEquals(2, customerForms.size());
		customerFormFunc.removeCustomerForm(form1);
		customerForms = customerFormFunc.getCustomerForms();
		assertEquals(1, customerForms.size());
	}
	
	@Test
	public void testForm() {
		assertEquals("name", form0.getCustomerName());
		assertEquals("accident", form0.getAccidentDesc());
		assertEquals("iet4583", form0.getLicensePlate());
		assertEquals("078181818", form0.getCustomerPhone());
		assertEquals("test@email.se", form0.getCustomerEmail());
	}
	
}
