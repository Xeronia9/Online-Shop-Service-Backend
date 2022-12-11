package menu.imp;

import java.util.Scanner;

import configs.ApplicationContext;
import menu.Menu;
import services.UserManagementService;
import services.imp.DefaultUserManagementService;

public class ChangeEmailMenu implements Menu{
	private ApplicationContext context;
	private UserManagementService instance;
	
	{
		context = ApplicationContext.getInstance();
		instance = DefaultUserManagementService.getInstance();
	}

	@Override
	public void start() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your new email");
		String email = sc.nextLine();
		
		if (email.isEmpty()) {
			System.out.println("The email cannot be empty. Please try again");
			this.start();
		} else if (instance.getUserByEmail(email) != null) {
			System.out.println("This email is already used by another user. Please try another email");
			this.start();
		} else {
			context.getLoggedInUser().setEmail(email);
			System.out.println("Your email has been successfully changed");
		}
		context.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {}

}
