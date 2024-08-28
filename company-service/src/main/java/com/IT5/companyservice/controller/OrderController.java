package com.IT5.companyservice.controller;


import com.IT5.companyservice.dao.CompanyDao;
import com.IT5.companyservice.model.Company;
import com.IT5.companyservice.model.OrderDto;
import com.IT5.companyservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("company/order")

public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    CompanyDao companyDao;

    @PostMapping("create")
    public ResponseEntity<String> register(@RequestBody OrderDto orderDto){
        Integer orderId = orderService.create(orderDto).getBody();
        Company company= companyDao.findById(orderDto.getCompanyId()).get();
        List<Integer> orderIds = company.getOrderIds();
        orderIds.add(orderId);
        company.setOrderIds(orderIds);
        companyDao.save(company);
        return new ResponseEntity<>("sucess", HttpStatus.CREATED);
    }

    @PostMapping("getOrders")
    public ResponseEntity<List<Object>> getOrdersFromId(@RequestBody List<Integer> ordersIds){
        return orderService.getOrdersFromId(ordersIds);
    }


}