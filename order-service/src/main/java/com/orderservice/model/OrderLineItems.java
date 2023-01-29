package com.orderservice.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "t_order_line_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderLineItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skuCode ;
    private BigDecimal price;
    private Integer quantity ;
}
