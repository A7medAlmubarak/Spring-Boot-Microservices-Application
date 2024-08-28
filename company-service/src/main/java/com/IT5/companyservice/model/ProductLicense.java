package com.IT5.companyservice.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity

public class ProductLicense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer productId;
    private Integer companyId;
}
