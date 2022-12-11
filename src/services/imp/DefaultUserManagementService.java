package services.imp;

import java.util.Arrays;

import entities.User;
import services.UserManagementService;

public class DefaultUserManagementService implements UserManagementService {
	
	private static final String NOT_UNIQUE_EMAIL_ERROR_MESSAGE = "This email is already used by another user. Please use another email";
	private static final String EMPTY_EMAIL_ERROR_MESSAGE = "You have to input email to register. Please, try one more time";
	private static final String NO_ERROR_MESSAGE = "";
	
	private static DefaultUserManagementService instance;
	
	private User[] users;
	
	private DefaultUserManagementService() {
		
	}

	@Override
	public String registerUser(User user) {
		// TODO Auto-generated method stub
		
		String errorMessage = checkUniqueEmail(user.getEmail());
		if (!errorMessage.equals("")) {
			return errorMessage;
		}
		if (users == null) {
			users = new User[1];
			users[0] = user;
		} else {
			User[] copyUsers = Arrays.copyOf(users, users.length + 1);
			copyUsers[copyUsers.length - 1] = user;
			users = copyUsers;
			
		}
		return errorMessage;
	}

	@Override
	public User[] getUsers() {
		// TODO Auto-generated method stub
		if (users == null) {
			users = new User[0];
		}
		return users;
	}

	@Override
	public User getUserByEmail(String email) {
		if (users == null) {
			return null;
		}
		for (int i = 0;i < users.length;i++) {
			if (users[i].getEmail().equals(email)) {
				return users[i];
			}
		}
		return null;
	}
	
	void clearServiceState() {
		users = null;
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
