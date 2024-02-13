package com.microservices.orderservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "t_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id

    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "order_id")
    @SequenceGenerator(name="order_id",sequenceName = "order_id_seq",allocationSize = 1)
    @Column(name="order_id")
    private Long orderId;
    private String orderNumber;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLineItems> orderLineItemsList;
}