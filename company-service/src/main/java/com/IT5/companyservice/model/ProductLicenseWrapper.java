package com.IT5.companyservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class ProductLicenseWrapper {
    private Integer productId;

    public ProductLicenseWrapper(Integer productId ) {
        this.productId = productId;
    }

}
