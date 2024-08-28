package com.IT5.costumerservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Costumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ElementCollection
    private List<Integer> productIds;

    @ElementCollection
    private List<Integer> orderIds;
}
