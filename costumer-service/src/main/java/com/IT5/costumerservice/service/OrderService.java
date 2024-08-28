package com.IT5.costumerservice.service;

import com.IT5.costumerservice.feign.OrderInterface;
import com.IT5.costumerservice.model.Costumer;
import com.IT5.costumerservice.model.CostumerWrapper;
import com.IT5.costumerservice.model.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderInterface orderInterface;

    public ResponseEntity<Integer> create(OrderDto orderDto) {
        Integer orderId = orderInterface.create(orderDto).getBody();

        return orderInterface.create(orderDto);
    }

    //@HystrixCommand(fallbackMethod = "getOrderByIdFallback")
    public ResponseEntity<List<Object>> getOrdersFromId(List<Integer> orderIds) {
        return orderInterface.getOrdersFromId(orderIds);
    }

  /*  public ResponseEntity<OrderWrapper> getOrderByIdFallback(List<Integer> orderIds) {

        // Implement fallback behavior here
        // For example, return a default OrderWrapper or handle the error gracefully
    }*/


}
