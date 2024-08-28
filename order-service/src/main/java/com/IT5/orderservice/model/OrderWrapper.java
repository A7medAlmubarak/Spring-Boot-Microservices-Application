package com.IT5.orderservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class OrderWrapper {
    private Integer id;
    private ProductWrapper product;
    private CostumerWrapper costumer;
    private CostumerWrapper costumerOwner;
    private CompanyWrapper company;
    private CompanyWrapper companyOwner;

    public OrderWrapper(Integer id, CostumerWrapper costumerOwner , CostumerWrapper costumer , ProductWrapper product ,
                        CompanyWrapper company , CompanyWrapper companyOwner) {
        this.id = id;
        this.product = product;
        this.costumer = costumer;
        this.costumerOwner = costumerOwner;
        this.company = company;
        this.companyOwner = companyOwner;

    }

}


