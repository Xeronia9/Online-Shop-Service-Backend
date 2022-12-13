package entities.imp;

import java.util.ArrayList;
import java.util.Arrays;

import entities.Cart;
import entities.Product;

public class DefaultCart implements Cart{
	
	private ArrayList<Product> products = new ArrayList<>();

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.products.isEmpty();
	}

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		this.products.add(product);
	}

	@Override
	public ArrayList<Product> getProducts() {
		// TODO Auto-generated method stub
		return this.products;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		this.products = new ArrayList<>();
	}

}
