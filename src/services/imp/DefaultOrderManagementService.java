package services.imp;

import java.util.Arrays;

import entities.Order;
import services.OrderManagementService;

public class DefaultOrderManagementService implements OrderManagementService{
	
	private static final int DEFAULT_ORDER_CAPACITY = 10;
	
	private static DefaultOrderManagementService instance;
	
	private Order[] orders;
	
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
		if (orders == null) {
			orders = new Order[1];
			orders[0] = order;
		}else {
			Order[] copyOrders = Arrays.copyOf(orders, orders.length + 1);
			copyOrders[copyOrders.length - 1] = order;
			orders = copyOrders;
		}
		
		
	}

	@Override
	public Order[] getOrderByUserId(int userId) {
		int numberOfOrders = 0;
		if (orders == null) {
			return null;
		}
		for (Order order:orders) {
			if (order.getCustomerId() == userId) {
				numberOfOrders++;
			}
		}
		Order[] ordersBySameUser = new Order[numberOfOrders];
		int i = 0;
		for (Order order:orders) {
			if (order.getCustomerId() == userId) {
				ordersBySameUser[i] = order;
				i++;
			}
		}
		return ordersBySameUser;
	}

	@Override
	public Order[] getOrders() {
		// TODO Auto-generated method stub
		return orders;
	}
	
	void clearServiceState() {
		//TODO write clear service code
		orders = null;
	}

}
