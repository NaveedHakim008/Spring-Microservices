package com.microservices.orderservice.dto;

import com.microservices.orderservice.model.OrderLineItems;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    List<OrderLineItemsDto> orderLineItemsDtoList;
}

