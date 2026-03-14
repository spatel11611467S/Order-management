package com.OrderManagement.controller;


import com.OrderManagement.apiResponse.ApiResponse;
import com.OrderManagement.dto.OrderRequest;
import com.OrderManagement.dto.StatusUpdateRequest;
import com.OrderManagement.model.Order;
import com.OrderManagement.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }



    @PostMapping
    public ResponseEntity<ApiResponse<Order>> create(
            @RequestBody OrderRequest request) {

        Order order = service.createOrder(
                request.getCustomerName(),
                request.getAmount()
        );

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Order created successfully",
                        order
                )
        );
    }


    // 2. Get Order by ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Order>> getOrder(
            @PathVariable String id) {

        Order order = service.getOrder(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Order fetched successfully",
                        order
                )
        );
    }


    // 3. Update Status
    @PutMapping("/{id}/status")
    public ResponseEntity<ApiResponse<Order>> updateStatus(
            @PathVariable String id,
            @RequestBody StatusUpdateRequest request) {

        Order order = service.updateStatus(
                id,
                request.getStatus().name()
        );

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Order status updated successfully",
                        order
                )
        );
    }


    // 4. Get All Orders
    @GetMapping
    public ResponseEntity<ApiResponse<List<Order>>> getAll() {

        List<Order> orders = service.getAll();

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Orders retrieved successfully",
                        orders
                )
        );
    }
}