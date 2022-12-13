package services.imp;

import java.util.ArrayList;
import java.util.Arrays;

import entities.Order;
import services.OrderManagementService;

public class DefaultOrderManagementService implements OrderManagementService{
	
	private static DefaultOrderManagementService instance;
	
	private ArrayList<Order> orders = new ArrayList<>();
	
	private DefaultOrderManagementService() {
		
	}
	
	public static OrderManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultOrderManagementService();
		}
		return instance;
	}

	@Override
	public void addOrder(Order order) {
		// TODO Auto-generated method stub
		this.orders.add(order);	
	}

	@Override
	public ArrayList<Order> getOrderByUserId(int userId) {
		if (this.orders.isEmpty()) {
			return null;
		}
		
		ArrayList<Order> ordersBySameUser = new ArrayList<>();
		for (Order order:orders) {
			if (order.getCustomerId() == userId) {
				ordersBySameUser.add(order);
			}
		}
		return ordersBySameUser;
	}

	@Override
	public ArrayList<Order> getOrders() {
		// TODO Auto-generated method stub
		return this.orders;
	}
	
	void clearServiceState() {
		//TODO write clear service code
		this.orders.clear();
	}

}
