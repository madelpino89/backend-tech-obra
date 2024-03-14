package com.obramat.app.domain;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private int id;

    private Date date;
    private int totalProduct;
    private double totalPriceWithoutIVA;
    private double totalPriceWithIVA;

    @Enumerated(EnumType.STRING)
    private Status status;
}
