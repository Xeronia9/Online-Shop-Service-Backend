package menu.imp;

import java.util.Scanner;

import configs.ApplicationContext;
import menu.Menu;

public class SettingsMenu implements Menu{
	
	private ApplicationContext context;
	
	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		if (context.getLoggedInUser() == null) {
			System.out.println("Please log in or create new account to change your account settings");
			context.getMainMenu().start();
		}
		Scanner sc = new Scanner(System.in);
		printMenuHeader();
		System.out.println("1.Change Password\n2.Change Email");
		String input = sc.nextLine();
		
		Menu menuToNavigate = null;
		if (input.equals(MainMenu.MENU_COMMAND)) {
			context.getMainMenu().start();
		} else if (input.equals("1")) {
			menuToNavigate = new ChangePasswordMenu();
		} else if (input.equals("2")) {
			menuToNavigate = new ChangeEmailMenu();
		} else {
			System.out.println("Only 1, 2 is allowed. Try one more time");
			this.start();
		}
		menuToNavigate.start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***Settings***\n");
		
	}

}
