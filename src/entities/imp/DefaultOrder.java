package entities.imp;

import java.util.ArrayList;
import java.util.Arrays;

import entities.Order;
import entities.Product;

public class DefaultOrder implements Order{
	
	private static final int AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER = 16;
	
	private String creditCardNumber;
	private ArrayList<Product> products = new ArrayList<>();
	private int customerId;

	@Override
	public boolean isCreditCardNumberValid(String userInput) {
		// TODO Auto-generated method stub
		if (userInput.length() == AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER && userInput.matches("\\d{16}")) {
			return true;
		}
		return false;
	}

	@Override
	public void setCreditCardNumber(String userInput) {
		// TODO Auto-generated method stub
		this.creditCardNumber = userInput;
		
	}

	@Override
	public void setProducts(ArrayList<Product> products) {
		// TODO Auto-generated method stub
		this.products = products;
		
	}

	@Override
	public void setCustomerId(int customerId) {
		// TODO Auto-generated method stub
		this.customerId = customerId;
		
	}

	@Override
	public int getCustomerId() {
		// TODO Auto-generated method stub
		return this.customerId;
	}
	
	@Override
	public String toString() {
		return "Customer Id: " + this.customerId + "\nOrders: " + this.products + "\nCredit card number: " + hideCreditCardNumber(this.creditCardNumber) + "\n";
				
	}
	
	private String hideCreditCardNumber(String creditCard) {
		String hiddenCreditCardNumber = "************" + creditCard.substring(12, 16);
		return hiddenCreditCardNumber;
		
	}

}
