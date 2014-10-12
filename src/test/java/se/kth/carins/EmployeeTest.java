package se.kth.carins;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import se.kth.carins.Business.UsersFunc;
import se.kth.carins.Entities.Employee;
import se.kth.carins.storage.Storage;

public class EmployeeTest {
	private static Employee employee;
	private static UsersFunc users;
	
	@BeforeClass
	public static void Before() {
		employee = new Employee("name", "1234", "finance");
		users = new UsersFunc();
		users.addUser(employee);
	}
	
	@Test
	public void username() {
		assertEquals("name", employee.getUsername());
	}

	@Test
	public void password() {
		assertEquals("1234", employee.getPassword());
	}
	
	@Test
	public void authenticate() {
		assertEquals("finance", users.getUser("name", "1234"));
		assertEquals("0", users.getUser("name", "12345"));
	}
}
