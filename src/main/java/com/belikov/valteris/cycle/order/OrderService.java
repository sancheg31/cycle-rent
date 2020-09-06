package com.belikov.valteris.cycle.order;

import com.belikov.valteris.cycle.order.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    void save(Order newOrder);

    List<Order> getAll();

    Optional<Order> getById(Long id);

    void delete(Long id);
}
