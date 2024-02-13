package com.microservices.orderservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
@Entity
@Table(name="t_order_line_items")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItems {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "order_line_items_seq_generator")
    @SequenceGenerator(name="order_line_items_seq_generator",sequenceName = "order_line_items_seq",allocationSize = 1)
    private long orderLineItemsId;
    private String skuCode;

    private BigDecimal price;

    private Integer quantity;



}
