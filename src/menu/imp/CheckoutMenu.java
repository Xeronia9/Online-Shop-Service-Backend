package menu.imp;

import java.util.Scanner;

import configs.ApplicationContext;
import entities.Order;
import entities.imp.DefaultOrder;
import menu.Menu;
import services.OrderManagementService;
import services.imp.DefaultOrderManagementService;

public class CheckoutMenu implements Menu{
	
	private OrderManagementService instance;
	private ApplicationContext context;
	
	{
		instance = DefaultOrderManagementService.getInstance();
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();

		Order order = new DefaultOrder();
		
		System.out.println("Enter your credit card number without spaces and press enter if you confirm purchase");
		Scanner sc = new Scanner(System.in);
		while (true) {
			String creditCardNumber = sc.nextLine();
			//when user go back to main menu
			if (creditCardNumber.equals(MainMenu.MENU_COMMAND)) {
				context.getMainMenu().start();
			} else if (!order.isCreditCardNumberValid(creditCardNumber)) {
				System.out.println("You entered invalid credit card number. Valid credit card should contain 16 digits. "
						+ "Please try one more time");
			} else {
				order.setCreditCardNumber(creditCardNumber);
				order.setCustomerId(context.getLoggedInUser().getId());
				order.setProducts(context.getSessionCart().getProducts());
				instance.addOrder(order);
				context.getSessionCart().clear();
				System.out.println("Thanks a lot for your purchase. Details about order delivery are sent to your email.");
				break;
			}
		}
		
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***Check out***\n");
		
	}

}
