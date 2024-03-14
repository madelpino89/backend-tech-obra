package com.obramat.app.service;

import com.obramat.app.domain.OrderDTO;
import com.obramat.app.entity.Order;
import com.obramat.app.entity.Status;

import java.util.Date;
import java.util.List;

public interface OrderService {

    List<Order> getOrders(Date creationDate, Status status, double price);

    Order createOrder(OrderDTO orderDTO);

    Order getDetailsOrder(int id);

    Order updateOrder(Order order);

    Order deleteOrder(int id);

    List<Order> getAll();
}
