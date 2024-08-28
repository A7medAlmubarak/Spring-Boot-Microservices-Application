package com.IT5.costumerservice.dao;

import com.IT5.costumerservice.model.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostumerDao extends JpaRepository<Costumer, Integer> {
}
