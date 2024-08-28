package com.IT5.companyservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity

public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany
    private List<ProductLicense> productLicenses;

    @ElementCollection
    private List<Integer> orderIds;

}
