package com.OrderManagement.service;

import com.OrderManagement.exception.OrderNotFoundException;
import com.OrderManagement.model.Order;
import com.OrderManagement.model.OrderStatus;
import com.OrderManagement.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;

    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Order createOrder(String customerName, Double amount) {

        if (customerName == null || amount == null || amount <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        Order order = new Order(
                UUID.randomUUID().toString(),
                customerName,
                amount,
                OrderStatus.NEW
        );

        return repository.save(order);
    }

    @Override
    public Order getOrder(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found"));
    }

    @Override
    public Order updateStatus(String id, String status) {

        Order order = getOrder(id);

        OrderStatus newStatus = OrderStatus.valueOf(status);

        if (order.getStatus() == OrderStatus.NEW &&
                newStatus == OrderStatus.PROCESSING) {

            order.setStatus(newStatus);

        } else if (order.getStatus() == OrderStatus.PROCESSING &&
                newStatus == OrderStatus.COMPLETED) {

            order.setStatus(newStatus);

        } else {
            throw new IllegalArgumentException("Invalid status transition");
        }

        return order;
    }

    @Override
    public List<Order> getAll() {
        return repository.findAll();
    }
}
