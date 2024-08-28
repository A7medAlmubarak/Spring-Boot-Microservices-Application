package com.IT5.companyservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class CompanyWrapper {
    private Integer id;
    private String name;

    public CompanyWrapper(Integer id, String name ) {
        this.id = id;
        this.name = name;
    }

}
