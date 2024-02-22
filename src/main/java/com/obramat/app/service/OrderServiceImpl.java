package com.obramat.app.service;

import com.obramat.app.domain.Order;
import com.obramat.app.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Override
    public List<Product> getProductByName(List<String> productNames) {
        return null;
    }

    @Override
    public Order createOrder(Order order) {
        return null;
    }
}
