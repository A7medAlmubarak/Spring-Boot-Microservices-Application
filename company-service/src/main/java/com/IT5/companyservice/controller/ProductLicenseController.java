package com.IT5.companyservice.controller;

import com.IT5.companyservice.model.*;
import com.IT5.companyservice.service.ProductLicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("company/license")

public class ProductLicenseController {

    @Autowired
    ProductLicenseService productLicenseService;

    @PostMapping("create")
    public ResponseEntity<String> register(@RequestBody ProductLicenseDto productLicenseDto){
        return productLicenseService.create(productLicenseDto.getProductId(),productLicenseDto.getCompanyId());
    }

    @GetMapping("getAll")
    public ResponseEntity<List<ProductLicense>> getAllUsers(){
        return productLicenseService.getAllProductLicenses();
    }

    @GetMapping("get/{id}")
    public ResponseEntity<ProductLicenseWrapper> getById(@PathVariable Integer id){
        return productLicenseService.getById(id);
    }

}
