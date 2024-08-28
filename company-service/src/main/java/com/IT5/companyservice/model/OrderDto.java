package com.IT5.companyservice.model;

import lombok.Data;

@Data
public class OrderDto {
    Boolean status;
    Integer productId;
    Integer costumerId;
    Integer costumerOwnerId;
    Integer companyId;
    Integer companyOwnerId;
}
