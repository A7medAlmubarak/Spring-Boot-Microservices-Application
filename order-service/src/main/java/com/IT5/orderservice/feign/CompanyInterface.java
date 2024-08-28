package com.IT5.orderservice.feign;

import com.IT5.orderservice.model.CompanyWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("COMPANY-SERVICE")
public interface CompanyInterface {
    @GetMapping("company/get/{id}")
    public ResponseEntity<CompanyWrapper> getById(@PathVariable("id") Integer id);
}
