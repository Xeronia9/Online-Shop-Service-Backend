package services.imp;

import entities.Product;
import entities.imp.DefaultProduct;
import services.ProductManagementService;

public class DefaultProductManagementService implements ProductManagementService {
	
	private static DefaultProductManagementService instance;
	
	private static Product[] products;
	
	static {
		initProducts();
	}
	
	private DefaultProductManagementService() {
		
	}
	
	private static void initProducts() {
		products = new Product[] {
				new DefaultProduct("Tsuki ga kirei", "Romance", 5.0 , 1),
				new DefaultProduct("Kimetsu no yaiba", "Action", 10.0, 2),
				new DefaultProduct("One piece", "Adventure", 40.0, 3),
				new DefaultProduct("Oregairu", "Drama", 20.0, 4),
				new DefaultProduct("Death note", "Thriller", 15.0, 5),
				new DefaultProduct("Dxd", "Ecchi", 7.0, 6),
				new DefaultProduct("Akame ga kill", "Gore", 8.0, 7)
		};
	}

	@Override
	public Product[] getProducts() {
		// TODO Auto-generated method stub
		return products;
	}

	@Override
	public Product getProductById(int productIdToAddToCart) {
		// TODO Auto-generated method stub
		for (int i = 0;i < products.length;i++) {
			if (productIdToAddToCart == products[i].getId()) {
				return products[i];
			}
		}
		return null;
	}
	
	public static ProductManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultProductManagementService();
		}
		return instance;
	}

}
