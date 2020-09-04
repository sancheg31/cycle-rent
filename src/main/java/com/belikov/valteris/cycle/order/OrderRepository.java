package com.belikov.valteris.cycle.order;

import com.belikov.valteris.cycle.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
