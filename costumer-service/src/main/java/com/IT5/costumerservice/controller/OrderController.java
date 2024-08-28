package com.IT5.costumerservice.controller;
import com.IT5.costumerservice.dao.CostumerDao;
import com.IT5.costumerservice.model.Costumer;
import com.IT5.costumerservice.model.OrderDto;
import com.IT5.costumerservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("costumer/order")

public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    CostumerDao costumerDao;

    @PostMapping("create")
    public ResponseEntity<String> register(@RequestBody OrderDto orderDto){
        System.out.println(orderDto);
        Integer orderId = orderService.create(orderDto).getBody();
        Costumer costumer= costumerDao.findById(orderDto.getCostumerId()).get();
        List<Integer> orderIds = costumer.getOrderIds();
        orderIds.add(orderId);
        costumer.setOrderIds(orderIds);
        costumerDao.save(costumer);
        return new ResponseEntity<>("sucess", HttpStatus.CREATED);
    }

    @PostMapping("getOrders")
    public ResponseEntity<List<Object>> getOrdersFromId(@RequestBody List<Integer> ordersIds){
        return orderService.getOrdersFromId(ordersIds);
    }


}
