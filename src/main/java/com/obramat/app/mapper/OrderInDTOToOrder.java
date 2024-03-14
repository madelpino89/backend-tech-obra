package com.obramat.app.mapper;

import com.obramat.app.domain.OrderDTO;
import com.obramat.app.entity.Order;
import com.obramat.app.entity.Product;
import com.obramat.app.entity.Status;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class OrderInDTOToOrder implements IMapper<OrderDTO, Order> {
    @Override
    public Order map(OrderDTO in) {
        Order order = new Order();
        order.setCreationDate(LocalDateTime.now());
        order.setStatus(Status.PENDING);
        order.setTotalProducts(in.getProducts().size());
        order.setTotalPriceWithIVA(calculateTotalPriceWithIVA(in));
        order.setTotalPriceWithoutIVA(calculateTotalPriceWithOutIVA(in));
        order.setProducts(in.getProducts());
        return order;
    }

    private double calculateTotalPriceWithOutIVA(OrderDTO in) {
        double total = in.getProducts().stream()
                .mapToDouble(Product::getPrice)
                .sum();

        return total - (total * 0.21);
    }

    private double calculateTotalPriceWithIVA(OrderDTO in) {
        return in.getProducts().stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
}
