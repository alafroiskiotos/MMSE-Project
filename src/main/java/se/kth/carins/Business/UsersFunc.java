package se.kth.carins.Business;

import java.util.Iterator;
import java.util.LinkedList;
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
	
	public String getUser(String username, String password) {
		Iterator<Employee> iterator = systemUsers.iterator();
		String result = "0";
		
		while(iterator.hasNext()) {
			Employee tmpUser = iterator.next();
			
			if (username.equals(tmpUser.getUsername()) && password.equals(tmpUser.getPassword())){
				result = tmpUser.getAcl();
			}
		}
		
		return result;
	}
}
