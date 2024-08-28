package com.IT5.companyservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class OrderWrapper {
    private Integer id;
    private Integer userId;
    private Integer ownerId;
    private Integer productId;

    public OrderWrapper(Integer id, Integer productId, Integer userId, Integer ownerId) {
        this.id = id;
        this.productId = productId;
        this.userId = userId;
        this.ownerId = ownerId;
    }
}