package menu.imp;

import java.util.Scanner;

import configs.ApplicationContext;
import menu.Menu;

public class ChangePasswordMenu implements Menu{
	
	private ApplicationContext context;
	
	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your old password");
		String oldPassword = sc.nextLine();
		System.out.println("Enter your new password");
		String newPassword = sc.nextLine();
		System.out.println("Enter your new password one more time");
		String newPasswordSecondTime = sc.nextLine();
		
		if (!context.getLoggedInUser().getPassword().equals(oldPassword)) {
			System.out.println("Unfortunately, your old password is wrong. Please try again");
			this.start();
		} else if (!newPassword.equals(newPasswordSecondTime)) {
			System.out.println("Unfortunately, your two new passwords do no match. Please try again");
			this.start();
		} else if (oldPassword.equals(newPassword)) {
			System.out.println("Your old password and new password cannot match. Please try again");
			this.start();
		} else {
			context.getLoggedInUser().setPassword(newPasswordSecondTime);
			System.out.println("Your password has been successfully changed");
			context.getMainMenu().start();
		}
	}

	@Override
	public void printMenuHeader() {}

}
