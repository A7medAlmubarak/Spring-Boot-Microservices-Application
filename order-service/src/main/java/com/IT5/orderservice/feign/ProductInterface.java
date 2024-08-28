package com.IT5.orderservice.feign;

import com.IT5.orderservice.model.ProductWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("PRODUCT-SERVICE")
public interface ProductInterface {
    @GetMapping("product/getAll")
    public ResponseEntity<List<ProductWrapper>> getAllProduct();

    @GetMapping("product/get/{id}")
    public ResponseEntity<ProductWrapper> getProductFromId(@PathVariable("id") Integer id);
}


