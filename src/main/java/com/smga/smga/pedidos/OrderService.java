package com.smga.smga.pedidos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional(rollbackFor = Exception.class)
    public void saveOrder(Order order) throws Exception {
        orderRepository.save(order);
        if (order.getQuantity() <= 0) {
            throw new Exception("Invalid quantity");
        }
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
