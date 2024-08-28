package com.IT5.orderservice.feign;

import com.IT5.orderservice.model.CompanyWrapper;
import com.IT5.orderservice.model.CostumerWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("COSTUMER-SERVICE")

public interface CostumerInterface {
    @GetMapping("costumer/get/{id}")
    public ResponseEntity<CostumerWrapper> getById(@PathVariable("id") Integer id);

}
