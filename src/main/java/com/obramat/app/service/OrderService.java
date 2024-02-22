package com.obramat.app.service;

import java.util.List;

import com.obramat.app.domain.Order;
import com.obramat.app.domain.Product;

public interface OrderService {

    List<Product> getProductByName(List<String> productNames);

    Order createOrder(Order order);

}
