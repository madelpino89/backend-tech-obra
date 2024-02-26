package com.obramat.app.controller;

import com.obramat.app.entity.Orders;
import com.obramat.app.entity.Product;
import com.obramat.app.entity.Status;
import com.obramat.app.service.OrdersService;
import com.obramat.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "obramat")
public class ObramatController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Orders>> ordersList(@PathVariable("date") Date creationDate,
                                                   @PathVariable("status") Status status,
                                                   @PathVariable("price") double price) {

        List<Orders> orders = ordersService.getOrders(creationDate, status, price);
        if (orders != null) {
            return new ResponseEntity<List<Orders>>(orders, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/orders", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Orders> createOrder(@RequestBody Orders order) {
        try {
            Orders newOrder = ordersService.createOrder(order);
            return new ResponseEntity<Orders>(newOrder, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/orders/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Orders> getOrderDetails(@PathVariable("id") int id) {
        Orders order = ordersService.getDetailsOrder(id);
        if (order != null) {
            return new ResponseEntity<Orders>(order, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/orders", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Orders> updateOrder(@RequestBody Orders order) {
        try {
            Orders updatedOrder = ordersService.updateOrder(order);
            if (updatedOrder != null) {
                return new ResponseEntity<Orders>(updatedOrder, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/orders/{id}")
    public ResponseEntity<Orders> deleteOrder(@PathVariable("id") int id) {
        Optional<Orders> existingOrder = Optional.ofNullable(ordersService.deleteOrder(id));
        if (existingOrder.isPresent()) {
            return new ResponseEntity<Orders>(existingOrder.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/products/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProductByName(@PathVariable("name") String name) {
        Product product = productService.productByName(name);
        if (product != null) {
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Orders> getAllOrders() {
        return ordersService.getAll();
    }

    @GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
