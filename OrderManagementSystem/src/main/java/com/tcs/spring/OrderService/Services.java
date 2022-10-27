package com.tcs.spring.OrderService;

import java.util.List;

import com.tcs.spring.OrderModel.Orders;
import com.tcs.springboot.patientmodel.Patient;

public interface Services {
	public List<Orders> getAllOrders();
	public Orders getOrderById(int id);
	public void saveOrder(Orders orders);
	public List<Orders> removeOrder(int id);
	public Integer update(Orders orders,int id);
	Patient consumeApi(int id);
}
