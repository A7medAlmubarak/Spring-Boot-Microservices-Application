package com.IT5.companyservice.dao;

import com.IT5.companyservice.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyDao extends JpaRepository<Company , Integer> {
}
