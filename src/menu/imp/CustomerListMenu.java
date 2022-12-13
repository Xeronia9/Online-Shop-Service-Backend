package menu.imp;

import java.util.Arrays;

import configs.ApplicationContext;
import menu.Menu;
import services.UserManagementService;
import services.imp.DefaultUserManagementService;

public class CustomerListMenu implements Menu{
	private ApplicationContext context;
	private UserManagementService instance;
	
	{
		context = ApplicationContext.getInstance();
		instance = DefaultUserManagementService.getInstance();
	}

	@Override
	public void start() {
		this.printMenuHeader();
		System.out.println(instance.getUsers());
		context.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***Customer List***\n");
		
	}

}
