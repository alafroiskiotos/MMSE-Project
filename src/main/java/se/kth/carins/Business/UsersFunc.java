package se.kth.carins.Business;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import se.kth.carins.Entities.Employee;
import se.kth.carins.storage.Storage;

public class UsersFunc {
	private List<Employee> systemUsers;
	
	public UsersFunc() {
		Storage storageInstance = Storage.getStorageInstance();
		systemUsers = storageInstance.getSystemUsersList();
	}
	
	public void addUser(Employee employee) {
		systemUsers.add(employee);
	}
	
	public String getUser(String username, char[] password) {
		Iterator<Employee> iterator = systemUsers.iterator();
		String result = "0";
		
		while(iterator.hasNext()) {
			Employee tmpUser = iterator.next();
			if (username.equals(tmpUser.getUsername()) && Arrays.equals(password , tmpUser.getPassword())){
				result = tmpUser.getAcl();
			}
		}
		
		return result;
	}
	
	public Employee getEmployee(String username, char[] password) {
		Iterator<Employee> iterator = systemUsers.iterator();
		Employee result = null;
		
		while(iterator.hasNext()) {
			Employee tmpUser = iterator.next();
			if (username.equals(tmpUser.getUsername()) && Arrays.equals(password , tmpUser.getPassword())){
				result = tmpUser;
			}
		}
		
		return result;
	}
}
