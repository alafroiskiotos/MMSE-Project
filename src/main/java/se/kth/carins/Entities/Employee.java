package se.kth.carins.Entities;

public class Employee {
	private String username;
	private String password;
	private String acl;
	
	public Employee(String username, String password, String acl) {
		this.username = username;
		this.password = password;
		this.acl = acl;
	}
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getAcl() {
		return acl;
	}
}
