package com.IT5.orderservice.dao;

import com.IT5.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order, Integer> {
}
