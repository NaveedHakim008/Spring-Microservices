package com.microservices.orderservice.repository;

import com.microservices.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface   OrderRepository extends JpaRepository<Order,Long> {

}