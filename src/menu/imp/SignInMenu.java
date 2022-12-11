package menu.imp;

import java.util.Scanner;

import configs.ApplicationContext;
import entities.User;
import menu.Menu;
import services.UserManagementService;
import services.imp.DefaultUserManagementService;

public class SignInMenu implements Menu{
	
	private ApplicationContext context;
	private UserManagementService instance;
	
	{
		context = ApplicationContext.getInstance();
		instance = DefaultUserManagementService.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your email");
		String email = sc.nextLine();
		System.out.println("Enter your password");
		String password = sc.nextLine();
		
		User user = instance.getUserByEmail(email);
		if (user == null || !user.getPassword().equals(password)) {
			System.out.println("Unfortunately, such login and password does not exist");
		} else {
			context.setLoggedInUser(user);
			System.out.println("Glad to see you back " + user.getFirstName() + " " + user.getLastName());
		}
		context.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***Sign In***\n");
		
	}

}
