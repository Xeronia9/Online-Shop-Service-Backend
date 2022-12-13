package menu.imp;

import java.util.Arrays;
import java.util.Scanner;

import configs.ApplicationContext;
import menu.Menu;
import services.OrderManagementService;
import services.imp.DefaultOrderManagementService;

public class MyOrdersMenu implements Menu{
	
	private ApplicationContext context;
	private OrderManagementService instance;
	
	{
		context = ApplicationContext.getInstance();
		instance = DefaultOrderManagementService.getInstance();
	}

	@Override
	public void start() {
		if (context.getLoggedInUser() == null) {
			System.out.println("Please, log in or create new account to see lists of your orders");
			context.getMainMenu().start();
		}
		
		printMenuHeader();
		if (instance.getOrders().isEmpty() || instance.getOrderByUserId(context.getLoggedInUser().getId()).isEmpty()) {
			System.out.println("Unfortunately, you don't have any orders yet. Navigate back to main menu to place a new order");
			context.getMainMenu().start();
		}else {
			System.out.println(instance.getOrderByUserId(context.getLoggedInUser().getId()));
			
		}
		context.getMainMenu().start();
		
		
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***My Orders***\n");
		
	}

}
