package com.IT5.companyservice.feign;

import com.IT5.companyservice.model.ProductWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("PRODUCT-SERVICE")

public interface ProductInterface {
    @GetMapping("product/getAll")
    public ResponseEntity<List<ProductWrapper>> getAllProduct();

    @PostMapping("product/get/{id}")
    public ResponseEntity<ProductWrapper> getProductFromId(@RequestBody Integer productId);

    @PostMapping("product/create")
    public ResponseEntity<Integer> create(@RequestBody String name , Integer userId);
}
