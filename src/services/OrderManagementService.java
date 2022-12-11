package services;

import entities.Order;

public interface OrderManagementService {
	
	void addOrder(Order order);
	
	Order[] getOrderByUserId(int userId);
	
	Order[] getOrders();

}
