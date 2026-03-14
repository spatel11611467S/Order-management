package com.OrderManagement.service;



import com.OrderManagement.model.Order;

import java.util.List;

public interface OrderService {

    Order createOrder(String customerName, Double amount);

    Order getOrder(String id);

    Order updateStatus(String id, String status);

    List<Order> getAll();
}