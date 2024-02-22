package com.obramat.app.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date date;
    private int totalProduct;
    private double totalPriceWithoutIVA;
    private double totalPriceWithIVA;

    @Enumerated(EnumType.STRING)
    private Status status;
}
