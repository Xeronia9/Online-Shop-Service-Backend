package menu.imp;

import java.util.Arrays;
import java.util.Scanner;

import configs.ApplicationContext;
import entities.Product;
import menu.Menu;
import services.ProductManagementService;
import services.imp.DefaultProductManagementService;

public class ProductCatalogMenu implements Menu{
	
	private ApplicationContext context;
	private ProductManagementService instance;
	
	{
		context = ApplicationContext.getInstance();
		instance = DefaultProductManagementService.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
		
		Scanner sc = new Scanner(System.in);		
		System.out.println("Enter product id to add it to the cart or 'menu' if you want to navigate back to main menu");
		
		while (true) {
			System.out.println(Arrays.toString(instance.getProducts()));
			String input = sc.nextLine();
			//when user type main menu
			if (input.equalsIgnoreCase(MainMenu.MENU_COMMAND)) {
				break;
				//when user is not logged in
			} else if (context.getLoggedInUser() == null) {
				System.out.println("You are not logged in. Please, sign in or create new account");
				break;
				//when user checkout with empty cart
			} else if(input.equalsIgnoreCase("checkout") && context.getSessionCart().isEmpty()) {
				//write code for checking out
				System.out.println("Your cart is empty. Please add product to cart first and then proceed with checkout");
				start();
				//when user checkout with item in cart
			} else if (input.equalsIgnoreCase("checkout")) {
				Menu checkout = new CheckoutMenu();
				checkout.start();
				break;
				//when user add products to cart
			} else {
				try {
					Product productToAdd = instance.getProductById(Integer.valueOf(input));
					context.getSessionCart().addProduct(productToAdd);
						
					System.out.println("Product " + productToAdd.getProductName() + " has been added to your cart. If you want to add a"
							+ " new product - enter product id. If you want to proceed with checkout - enter word 'checkout' to console");
					continue;
				} catch (Exception e) {
					System.out.println("Please, enter product ID if you want to add product to cart. "
							+ "Or enter 'checkout' if you want to proceed with checkout. "
							+ "Or enter 'menu' if you want to navigate back to the main menu.");
					continue;
				}
			}			
		}
		context.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***Product Catalog***\n");
		
	}

}
