package se.kth.carins.Entities;

public class Employee {
	private String username;
	char[] password;
	private String acl;
	
	public Employee(String username, char[] password, String acl) {
		this.username = username;
		this.password = password;
		this.acl = acl;
	}
	
	public String getUsername() {
		return username;
	}
	public char[] getPassword() {
		return password;
	}
	public String getAcl() {
		return acl;
	}
}
