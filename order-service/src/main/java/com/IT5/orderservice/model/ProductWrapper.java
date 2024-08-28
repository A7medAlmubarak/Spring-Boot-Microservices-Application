package com.IT5.orderservice.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ProductWrapper {
    private Integer id;
    private String name;
    private Integer userId;

    public ProductWrapper(Integer id, String name, Integer userId) {
        this.id = id;
        this.name = name;
        this.userId = userId;
    }
}
