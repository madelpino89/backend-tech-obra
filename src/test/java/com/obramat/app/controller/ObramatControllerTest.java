package com.obramat.app.controller;

import com.obramat.app.entity.Order;
import com.obramat.app.entity.Product;
import com.obramat.app.entity.Status;
import com.obramat.app.service.OrderService;
import com.obramat.app.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@WebMvcTest(ObramatController.class)
class ObramatControllerTest {

    @Mock
    private OrderService orderService;

    @Mock
    private ProductService productService;

    @InjectMocks
    private ObramatController obramatController;

    @Test
    public void testOrdersList() {
        // Arrange
        Date creationDate = new Date();
        Status status = Status.PENDING;
        double price = 100.0;
        List<Order> orders = new ArrayList<>();

        when(orderService.getOrders(creationDate, status, price)).thenReturn(orders);

        // Act
        ResponseEntity<List<Order>> responseEntity = obramatController.ordersList(creationDate, status, price);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(orders, responseEntity.getBody());
    }

    @Test
    public void testCreateOrder() {
        // Arrange
        Order order = new Order();
        when(orderService.createOrder(order)).thenReturn(order);

        // Act
        ResponseEntity<Order> responseEntity = obramatController.createOrder(order);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(order, responseEntity.getBody());
    }

    @Test
    public void testGetOrderDetails() {
        // Arrange
        int orderId = 1;
        Order order = new Order();
        when(orderService.getDetailsOrder(orderId)).thenReturn(order);

        // Act
        ResponseEntity<Order> responseEntity = obramatController.getOrderDetails(orderId);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(order, responseEntity.getBody());
    }

    @Test
    public void testUpdateOrder() {
        // Arrange
        Order order = new Order();
        when(orderService.updateOrder(order)).thenReturn(order);

        // Act
        ResponseEntity<Order> responseEntity = obramatController.updateOrder(order);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(order, responseEntity.getBody());
    }

    @Test
    public void testDeleteOrder() {
        // Arrange
        int orderId = 1;
        Order order = new Order();
        Optional<Order> existingOrder = Optional.of(order);
        when(orderService.deleteOrder(orderId)).thenReturn(existingOrder.get());

        // Act
        ResponseEntity<Order> responseEntity = obramatController.deleteOrder(orderId);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(order, responseEntity.getBody());
    }

    @Test
    public void testGetProductByName() {
        // Arrange
        String productName = "Test Product";
        Product product = new Product();
        when(productService.productByName(productName)).thenReturn(product);

        // Act
        ResponseEntity<Product> responseEntity = obramatController.getProductByName(productName);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(product, responseEntity.getBody());
    }

    @Test
    public void testGetAllOrders() {
        // Arrange
        List<Order> orders = new ArrayList<>();
        when(orderService.getAll()).thenReturn(orders);

        // Act
        List<Order> result = obramatController.getAllOrders();

        // Assert
        assertEquals(orders, result);
    }

    @Test
    public void testGetAllProducts() {
        // Arrange
        List<Product> products = new ArrayList<>();
        when(productService.getAllProducts()).thenReturn(products);

        // Act
        List<Product> result = obramatController.getAllProducts();

        // Assert
        assertEquals(products, result);
    }
}