package com.obramat.app.service;

import com.obramat.app.entity.Product;

import java.util.List;

public interface ProductService {

    Product productByName(String name);

    List<Product> getAllProducts();
}
