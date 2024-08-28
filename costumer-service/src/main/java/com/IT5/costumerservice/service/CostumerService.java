package com.IT5.costumerservice.service;

import com.IT5.costumerservice.dao.CostumerDao;
import com.IT5.costumerservice.model.Costumer;
import com.IT5.costumerservice.model.CostumerWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class CostumerService {
    @Autowired
    CostumerDao costumerDao;

    public ResponseEntity<String> register(String name) {
        Costumer costumer = new Costumer();
        costumer.setName(name);
        costumerDao.save(costumer);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<Costumer>> getAllCostumers() {
        try {
            return new ResponseEntity<>(costumerDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<CostumerWrapper> getById(Integer id) {
        Costumer costumer = costumerDao.findById(id).get();

        CostumerWrapper wrapper = new CostumerWrapper();
        wrapper.setId(costumer.getId());
        wrapper.setName(costumer.getName());


        return new ResponseEntity<>(wrapper, HttpStatus.OK);
    }
}
