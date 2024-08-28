package com.IT5.productservice.service;

import com.IT5.productservice.dao.ProductDao;
import com.IT5.productservice.model.Product;
import com.IT5.productservice.model.ProductWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

public class ProductService {
    @Autowired
    ProductDao productDao;

    public ResponseEntity<String> create(String name, Integer userId) {
        Product product = new Product();
        product.setName(name);
        product.setUserId(userId);
        productDao.save(product);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<Product>> getAllProducts() {
        try {
            return new ResponseEntity<>(productDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<ProductWrapper> getById(Integer id) {
        System.out.println("productId is :" +id);
        Product product = productDao.findById(id).get();
        ProductWrapper wrapper = new ProductWrapper();
        wrapper.setId(product.getId());
        wrapper.setName(product.getName());
        wrapper.setUserId(product.getUserId());
        return new ResponseEntity<>(wrapper, HttpStatus.OK);
    }


}
