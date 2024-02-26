package com.obramat.app.service;

import java.util.Date;
import java.util.List;

import com.obramat.app.entity.Orders;
import com.obramat.app.entity.Product;
import com.obramat.app.entity.Status;

public interface OrdersService {

    List<Orders> getOrders(Date creationDate, Status status, double price);

    Orders createOrder(Orders order);

    Orders getDetailsOrder(int id);

    Orders updateOrder(Orders order);

    Orders deleteOrder(int id);

    List<Orders> getAll();
}
