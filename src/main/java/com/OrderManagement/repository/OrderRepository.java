package com.OrderManagement.repository;


import com.OrderManagement.model.Order;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class OrderRepository {

    private final Map<String, Order> orderMap = new HashMap<>();

    public Order save(Order order) {
        orderMap.put(order.getOrderId(), order);
        return order;
    }

    public Optional<Order> findById(String id) {
        return Optional.ofNullable(orderMap.get(id));
    }

    public List<Order> findAll() {
        return new ArrayList<>(orderMap.values());
    }
}
