package com.obramat.app.domain;

import com.obramat.app.entity.Product;
import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {
    private List<Product> products;
}
