package com.IT5.orderservice.controller;
import com.IT5.orderservice.model.Order;
import com.IT5.orderservice.model.OrderDto;
import com.IT5.orderservice.model.OrderWrapper;
import com.IT5.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.env.Environment;

import java.util.List;


@RestController
@RequestMapping("/order")

public class OrderController {
    @Autowired
    Environment environment;

    @Autowired
    OrderService orderService;

    @PostMapping("create")
    public ResponseEntity<Integer> create(@RequestBody OrderDto orderDto){
        return orderService.create(orderDto.getProductId(),orderDto.getCostumerOwnerId(),
                orderDto.getCostumerId(),orderDto.getCompanyOwnerId()
                ,orderDto.getCompanyId());
    }

    @PostMapping("getAll")
    public ResponseEntity<List<Order>> getAllProducts(){
        return orderService.getAllOrders();
    }

    @PostMapping("getOrders")
    public ResponseEntity<List<OrderWrapper>> getOrdersFromId(@RequestBody List<Integer> ordersIds){
        System.out.println(environment.getProperty("local.server.port"));
        return orderService.getOrdersFromId(ordersIds);
    }


    @GetMapping("/{id}")
    public ResponseEntity<OrderWrapper> getOrderById(@PathVariable Integer id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/{id}/accept")
    public ResponseEntity<OrderWrapper> accept(@PathVariable Integer id) {
        return orderService.accept(id);
    }

    @GetMapping("/{id}/reject")
    public ResponseEntity<OrderWrapper> reject(@PathVariable Integer id) {
        return orderService.reject(id);
    }

}
