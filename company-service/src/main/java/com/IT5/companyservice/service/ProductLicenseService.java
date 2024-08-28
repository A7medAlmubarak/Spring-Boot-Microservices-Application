package com.IT5.companyservice.service;

import com.IT5.companyservice.dao.ProductLicenseDao;
import com.IT5.companyservice.model.ProductLicense;
import com.IT5.companyservice.model.ProductLicenseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductLicenseService {
    @Autowired
    ProductLicenseDao productLicenseDao;

    public ResponseEntity<String> create(Integer productId,Integer companyId) {
        ProductLicense productLicense = new ProductLicense();
        productLicense.setProductId(productId);
        productLicense.setCompanyId(companyId);
        productLicenseDao.save(productLicense);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<ProductLicense>> getAllProductLicenses() {
        try {
            return new ResponseEntity<>(productLicenseDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<ProductLicenseWrapper> getById(Integer id) {
        ProductLicense productLicense = productLicenseDao.findById(id).get();

        ProductLicenseWrapper wrapper = new ProductLicenseWrapper();
        wrapper.setProductId(productLicense.getProductId());
        return new ResponseEntity<>(wrapper, HttpStatus.OK);
    }

}
