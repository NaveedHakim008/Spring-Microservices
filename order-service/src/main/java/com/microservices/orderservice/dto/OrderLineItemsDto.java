package com.microservices.orderservice.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItemsDto {

    private long id;
    private String skuCode;

    private BigDecimal price;

    private Integer quantity;
}
