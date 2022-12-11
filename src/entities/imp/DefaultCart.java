package entities.imp;

import java.util.Arrays;

import entities.Cart;
import entities.Product;

public class DefaultCart implements Cart{
	
	private Product[] products;

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (this.products == null) {
			return true;
		}
		return false;
	}

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		if (this.products == null) {
			this.products = new Product[1];
			this.products[0] = product;
		} else {
			Product[] newCart = Arrays.copyOf(this.products, this.products.length + 1);
			newCart[newCart.length - 1] = product;
			this.products = newCart;
		}
		
	}

	@Override
	public Product[] getProducts() {
		// TODO Auto-generated method stub
		return this.products;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		if (!this.isEmpty()) {
			this.products = null;
		}
	}

}
