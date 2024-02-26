package com.obramat.app.service;

import com.obramat.app.entity.Orders;
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
    public List<Orders> getOrders(Date creationDate, Status status, double price) {
        List<Orders> allOrders = ordersRepository.findAll();

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
    public Orders createOrder(Orders order) {
        Orders newOrder = ordersRepository.save(order);
        List<Product> products = order.getProducts().stream()
                .peek(product -> product.setOrders(newOrder))
                .toList();

        productRepository.saveAll(products);

        return newOrder;
    }

    @Override
    public Orders getDetailsOrder(int id) {
        return ordersRepository.findById(id).orElse(null);
    }

    @Override
    public Orders updateOrder(Orders order) {
        Optional<Orders> existingOrder = ordersRepository.findById(order.getId());
        if (existingOrder.isPresent()) {
            Orders updated = ordersRepository.save(order);
            return updated;
        }
        return null;
    }

    @Override
    public Orders deleteOrder(int id) {
        Optional<Orders> existingOrder = ordersRepository.findById(id);
        if (existingOrder.isPresent()) {
            ordersRepository.deleteById(id);
            return existingOrder.get();
        }
        return null;
    }

    @Override
    public List<Orders> getAll() {
        return ordersRepository.findAll();
    }
}
