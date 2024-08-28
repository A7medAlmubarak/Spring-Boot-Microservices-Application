package com.IT5.companyservice.dao;

import com.IT5.companyservice.model.ProductLicense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductLicenseDao extends JpaRepository<ProductLicense, Integer> {
}
