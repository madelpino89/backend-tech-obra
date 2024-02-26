package com.obramat.app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
@Data
public class Orders implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "total_product")
    private int totalProduct;

    @Column(name = "total_price_without_iva")
    private double totalPriceWithoutIVA;

    @Column(name = "total_price_with_iva")
    private double totalPriceWithIVA;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<Product> products;
}
