package services.imp;

import java.util.ArrayList;
import java.util.Arrays;

import entities.User;
import services.UserManagementService;

public class DefaultUserManagementService implements UserManagementService {
	
	private static final String NOT_UNIQUE_EMAIL_ERROR_MESSAGE = "This email is already used by another user. Please use another email";
	private static final String EMPTY_EMAIL_ERROR_MESSAGE = "You have to input email to register. Please, try one more time";
	private static final String NO_ERROR_MESSAGE = "";
	
	private static DefaultUserManagementService instance;
	
	private ArrayList<User> users = new ArrayList<>();
	
	private DefaultUserManagementService() {
		
	}

	@Override
	public String registerUser(User user) {
		// TODO Auto-generated method stub
		
		String errorMessage = checkUniqueEmail(user.getEmail());
		if (!errorMessage.equals("")) {
			return errorMessage;
		}
		this.users.add(user);
		return errorMessage;
	}

	@Override
	public ArrayList<User> getUsers() {
		// TODO Auto-generated method stub
		
		return users;
	}

	@Override
	public User getUserByEmail(String email) {
		if (users.isEmpty()) {
			return null;
		}
		for (int i = 0;i < users.size();i++) {
			if (users.get(i).getEmail().equals(email)) {
				return users.get(i);
			}
		}
		return null;
	}
	
	void clearServiceState() {
		users.clear();
	}
	
	public static UserManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultUserManagementService();
		}
		return instance;
	}
	
	private String checkUniqueEmail(String email) {
		if (email.isEmpty()) {
			return EMPTY_EMAIL_ERROR_MESSAGE;
		} else if (getUserByEmail(email) != null) {
			return NOT_UNIQUE_EMAIL_ERROR_MESSAGE;
		} else {
			return NO_ERROR_MESSAGE;
		}
	}
	
	

}
