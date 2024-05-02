package com.codinftitans.backend.controller;

import com.codinftitans.backend.model.Order;
import com.codinftitans.backend.repository.UpdateOrderRepository;
import com.codinftitans.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.UpdateBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    private final OrderService orderService;
    @Autowired
    public UpdateOrderRepository updateOrderRepository;

    @Autowired
    public OrderController(OrderService orderService, UpdateOrderRepository updateOrderRepository) {
        this.orderService = orderService;
        this.updateOrderRepository = updateOrderRepository;
    }

    @PostMapping("/order/new")
    public Order save(@RequestBody Order order){
        return orderService.save(order);
    }

    @GetMapping("/order/all")
    public List<Order> findAll(){
        return orderService.findAll();
    }

    @GetMapping("/order/{id}")
    public Optional<Order> findOne(
            @PathVariable int id
    ){
        return orderService.getOne(id);
    }
    @GetMapping ("/order/status")
    public String updateStatus(@RequestParam String email){
        updateOrderRepository.updateOrderStatus(email);
        return "updated successfully";
    }
}
