package com.IT5.orderservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class CostumerWrapper {
    private Integer id;
    private String name;

    public CostumerWrapper(Integer id, String name ) {
        this.id = id;
        this.name = name;
    }
}
