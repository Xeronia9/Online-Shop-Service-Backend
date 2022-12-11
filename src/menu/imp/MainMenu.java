package menu.imp;

import java.util.Scanner;

import configs.ApplicationContext;
import menu.Menu;

public class MainMenu implements Menu{
	
	public static final String MENU_COMMAND = "menu";
	
	private static final String MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER = "1. Sign Up \n2. Sign In \n3. Product Catalog \n4. My Orders \n5. Settings \n6. Customer List";

	private static final String MAIN_MENU_TEXT_FOR_LOGGED_IN_USER = "1. Sign Up \n2. Sign Out \n3. Product Catalog \n4. My Orders \n5. Settings \n6. Customer List";
	
	private ApplicationContext context;
	
	{
		context = ApplicationContext.getInstance();
	}
	@Override
	public void start() {
		// TODO Auto-generated method stub
		if (context.getMainMenu() == null) {
			context.setMainMenu(this);
		}
		
		printMenuHeader();
		if (context.getLoggedInUser() == null) {
			System.out.println(MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER);
		} else {
			System.out.println(MAIN_MENU_TEXT_FOR_LOGGED_IN_USER);
		}
		
		Scanner sc = new Scanner(System.in);
		String number = sc.nextLine();
		
		Menu menuToNavigate = null;
		
		if (number.equalsIgnoreCase("exit")) {
			System.out.println("Thank you for using our service!");
		} else if (number.equals("1")) {
			menuToNavigate = new SignUpMenu();
		} else if (number.equals("2")) {
			if (context.getLoggedInUser() == null) {
				menuToNavigate = new SignInMenu();
			} else {
				menuToNavigate = new SignOutMenu();
			}
		} else if (number.equals("3")) {
			menuToNavigate = new ProductCatalogMenu();
		} else if (number.equals("4")) {
			menuToNavigate = new MyOrdersMenu();
		} else if (number.equals("5")) {
			menuToNavigate = new SettingsMenu();
		} else if (number.equals("6")) {
			menuToNavigate = new CustomerListMenu();
		} else {
			System.out.println("Only numbers 1-6 are allowed, please try again!");
			start();
		}
		menuToNavigate.start();
	}

	@Override
	public void printMenuHeader() {
		// TODO Auto-generated method stub
		System.out.println("***Main Menu***\n");
	}

}
