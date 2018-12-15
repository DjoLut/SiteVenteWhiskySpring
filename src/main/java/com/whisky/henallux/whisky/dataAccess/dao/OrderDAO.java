package com.whisky.henallux.whisky.dataAccess.dao;

import com.whisky.henallux.whisky.dataAccess.repository.OrderRepository;
import com.whisky.henallux.whisky.model.Order;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class OrderDAO {
    private OrderRepository orderRepository;

    @Autowired
    public OrderDAO(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }
}
