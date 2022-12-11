package entities.imp;

import entities.User;

public class DefaultUser implements User{
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private int uniqueId;
	private static int id;
	
	public DefaultUser() {
		
	}
	
	public DefaultUser(String firstName, String lastName, String password, String email) {
		id++;
		this.uniqueId = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
	}
	

	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return this.firstName;
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return this.lastName;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return this.email;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.uniqueId;
	}

	@Override
	public void setPassword(String newPassword) {
		// TODO Auto-generated method stub
		this.password = newPassword;
		
	}

	@Override
	public void setEmail(String newEmail) {
		// TODO Auto-generated method stub
		this.email = newEmail;
		
	}
	
	void clearState() {
		id = 0;
	}
	
	@Override
	public String toString() {
		return this.getFirstName() + " " + this.getLastName() + " " + this.getEmail() + "\n";
	}

}
