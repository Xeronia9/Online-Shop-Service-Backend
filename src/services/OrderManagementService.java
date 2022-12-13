package services;

import java.util.ArrayList;

import entities.Order;

public interface OrderManagementService {
	
	void addOrder(Order order);
	
	ArrayList<Order> getOrderByUserId(int userId);
	
	ArrayList<Order> getOrders();

}
