package com.belikov.valteris.cycle.order.impl;

import com.belikov.valteris.cycle.order.OrderRepository;
import com.belikov.valteris.cycle.order.OrderService;
import com.belikov.valteris.cycle.order.model.Order;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Override
    public void save(Order newOrder) {
        orderRepository.save(newOrder);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
