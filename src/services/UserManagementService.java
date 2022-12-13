package services;

import java.util.ArrayList;

import entities.User;

public interface UserManagementService {

	String registerUser(User user);
	
	ArrayList<User> getUsers();
	
	User getUserByEmail(String email);

}
