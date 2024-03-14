package com.obramat.app.service;

import com.obramat.app.entity.Order;
import com.obramat.app.entity.Status;

import java.util.Date;
import java.util.List;

public interface OrdersService {

    List<Order> getOrders(Date creationDate, Status status, double price);

    Order createOrder(Order order);

    Order getDetailsOrder(int id);

    Order updateOrder(Order order);

    Order deleteOrder(int id);

    List<Order> getAll();
}
