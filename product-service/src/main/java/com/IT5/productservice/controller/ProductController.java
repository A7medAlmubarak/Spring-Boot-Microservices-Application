package com.IT5.productservice.controller;

import com.IT5.productservice.model.Product;
import com.IT5.productservice.model.ProductDto;
import com.IT5.productservice.model.ProductWrapper;
import com.IT5.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("create")
    public ResponseEntity<String> create(@RequestBody ProductDto productDto){
        return productService.create(productDto.getName() ,productDto.getUserId());
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Product>> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("get/{id}")
    public ResponseEntity<ProductWrapper> getById(@PathVariable Integer id){
        return productService.getById(id);
    }

}
