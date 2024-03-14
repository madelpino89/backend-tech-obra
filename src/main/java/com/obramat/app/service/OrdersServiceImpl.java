package com.obramat.app.service;

import com.obramat.app.entity.Order;
import com.obramat.app.entity.Product;
import com.obramat.app.entity.Status;
import com.obramat.app.repository.OrdersRepository;
import com.obramat.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Order> getOrders(Date creationDate, Status status, double price) {
        List<Order> allOrders = ordersRepository.findAll();

        if (creationDate != null) {
            allOrders = allOrders.stream()
                    .filter(order -> order.getCreationDate().equals(creationDate))
                    .toList();
        }
        if (status != null) {
            allOrders = allOrders.stream()
                    .filter(order -> order.getStatus().equals(status))
                    .toList();
        }
        if (price > 0) {
            allOrders = allOrders.stream()
                    .filter(order -> order.getTotalPriceWithIVA() == price)
                    .toList();
        }

        return allOrders;
    }

    @Override
    public Order createOrder(Order order) {
        Order newOrder = ordersRepository.save(order);
        List<Product> products = order.getProducts().stream()
                .peek(product -> product.setOrder(newOrder))
                .toList();

        productRepository.saveAll(products);

        return newOrder;
    }

    @Override
    public Order getDetailsOrder(int id) {
        return ordersRepository.findById(id).orElse(null);
    }

    @Override
    public Order updateOrder(Order order) {
        Optional<Order> existingOrder = ordersRepository.findById(order.getId());
        if (existingOrder.isPresent()) {
            Order updated = ordersRepository.save(order);
            return updated;
        }
        return null;
    }

    @Override
    public Order deleteOrder(int id) {
        Optional<Order> existingOrder = ordersRepository.findById(id);
        if (existingOrder.isPresent()) {
            ordersRepository.deleteById(id);
            return existingOrder.get();
        }
        return null;
    }

    @Override
    public List<Order> getAll() {
        return ordersRepository.findAll();
    }
}
