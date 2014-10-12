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
		char[] pwd = { '1', '2', '3', '4'};
		employee = new Employee("name", pwd, "finance");
		users = new UsersFunc();
		users.addUser(employee);
	}
	
	@Test
	public void username() {
		assertEquals("name", employee.getUsername());
	}

	@Test
	public void password() {
		char[] pwd = { '1', '2', '3', '4'};
		assertArrayEquals(pwd, employee.getPassword());
		//assertEquals(pwd, employee.getPassword());
	}
	
	@Test
	public void authenticate() {
		char[] pwd = { '1', '2', '3', '4'};
		assertEquals("finance", users.getUser("name", pwd));
		assertEquals("0", users.getUser("notexistingname", pwd));
	}
}
