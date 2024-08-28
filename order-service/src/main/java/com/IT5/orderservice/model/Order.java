package com.IT5.orderservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = true)
    private Boolean status;
    @Column(nullable = true)
    private Integer productId;
    @Column(nullable = true)
    private Integer customerId;
    @Column(nullable = true)
    private Integer customerOwnerId;
    @Column(nullable = true)
    private Integer companyId;
    @Column(nullable = true)
    private Integer companyOwnerId;

}
