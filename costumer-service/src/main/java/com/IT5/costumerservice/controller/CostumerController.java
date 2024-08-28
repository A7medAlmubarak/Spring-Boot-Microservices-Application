package com.IT5.costumerservice.controller;

import com.IT5.costumerservice.model.Costumer;
import com.IT5.costumerservice.model.CostumerDto;
import com.IT5.costumerservice.model.CostumerWrapper;
import com.IT5.costumerservice.model.OrderDto;
import com.IT5.costumerservice.service.CostumerService;
import com.IT5.costumerservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("costumer")
public class CostumerController {
    @Autowired
    CostumerService costumerService;



    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody CostumerDto costumerDto){
        return costumerService.register(costumerDto.getName());
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Costumer>> getAllUsers(){
        return costumerService.getAllCostumers();
    }

    @GetMapping("get/{id}")
    public ResponseEntity<CostumerWrapper> getById(@PathVariable Integer id){
        return costumerService.getById(id);
    }


}
