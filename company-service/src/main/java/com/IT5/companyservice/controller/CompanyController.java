package com.IT5.companyservice.controller;

import com.IT5.companyservice.model.Company;
import com.IT5.companyservice.model.CompanyDto;
import com.IT5.companyservice.model.CompanyWrapper;
import com.IT5.companyservice.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("company")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody CompanyDto companyDto){
        return companyService.register(companyDto.getName());
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Company>> getAllUsers(){
        return companyService.getAllCompanies();
    }

    @GetMapping("get/{id}")
    public ResponseEntity<CompanyWrapper> getById(@PathVariable Integer id){
        return companyService.getById(id);
    }

}
