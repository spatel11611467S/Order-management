package com.OrderManagement.dto;


import com.OrderManagement.model.OrderStatus;

public class StatusUpdateRequest {

    private OrderStatus status;

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
