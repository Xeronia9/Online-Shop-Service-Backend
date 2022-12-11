package entities.imp;

import entities.Product;

public class DefaultProduct implements Product{
	
	private int id;
	private String productName;
	private String categoryName;
	private double price;
	
	public DefaultProduct() {
		
	}
	
	public DefaultProduct(String productName, String categoryName, double price, int id) {
		this.productName = productName;
		this.categoryName = categoryName;
		this.price = price;
		this.id = id;
		
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public String getProductName() {
		// TODO Auto-generated method stub
		return this.productName;
	}
	
	@Override
	public String toString() {
		return "Product name: " + this.productName + ", Product type: " + this.categoryName
				+ ", Id: " + this.id + ", Price: " + this.price + "\n";
	}

}
