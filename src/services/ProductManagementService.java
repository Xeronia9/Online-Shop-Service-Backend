package services;

import java.util.ArrayList;

import entities.Product;

public interface ProductManagementService {
	
	ArrayList<Product> getProducts();
	
	Product getProductById(int productIdToAddToCart);

}
