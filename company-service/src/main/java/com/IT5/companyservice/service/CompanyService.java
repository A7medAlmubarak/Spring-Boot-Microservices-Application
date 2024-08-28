package com.IT5.companyservice.service;

import com.IT5.companyservice.dao.CompanyDao;
import com.IT5.companyservice.model.Company;
import com.IT5.companyservice.model.CompanyWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {
    @Autowired
    CompanyDao companyDao;

    public ResponseEntity<String> register(String name) {
        Company company = new Company();
        company.setName(name);
        companyDao.save(company);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<Company>> getAllCompanies() {
        try {
            return new ResponseEntity<>(companyDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<CompanyWrapper> getById(Integer id) {
        Company company = companyDao.findById(id).get();

        CompanyWrapper wrapper = new CompanyWrapper();
        wrapper.setId(company.getId());
        wrapper.setName(company.getName());
        return new ResponseEntity<>(wrapper, HttpStatus.OK);
    }
}
