package menu.imp;

import java.util.Scanner;

import configs.ApplicationContext;
import entities.User;
import entities.imp.DefaultUser;
import menu.Menu;
import services.UserManagementService;
import services.imp.DefaultUserManagementService;

public class SignUpMenu implements Menu{
	
	private UserManagementService userManagementService;
	private ApplicationContext context;
	
	{
		userManagementService = DefaultUserManagementService.getInstance();
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		printMenuHeader();
		System.out.println("Enter your first name");
		String firstName = sc.nextLine();
		System.out.println("Enter your last name");
		String lastName = sc.nextLine();
		System.out.println("Enter your password");
		String password = sc.nextLine();
		System.out.println("Enter your email");
		String email = sc.nextLine();
		
		User user = new DefaultUser(firstName, lastName, password, email);
		
		String errorMessage = userManagementService.registerUser(user);
		if (!errorMessage.equals("")) {
			System.out.println(errorMessage);			
		} else {
			context.setLoggedInUser(user);
			System.out.println("New user is created");
		}
		context.getMainMenu().start();
		
		
	}

	@Override
	public void printMenuHeader() {
		// TODO Auto-generated method stub
		System.out.println("***Sign Up***\n");
		
	}

}
