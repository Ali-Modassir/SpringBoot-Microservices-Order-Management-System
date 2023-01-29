package com.orderservice.controller;

import com.orderservice.dto.OrderRequest;
import com.orderservice.dto.OrderResponse;
import com.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService ;

   @PostMapping("/create")
   @ResponseStatus(HttpStatus.CREATED)
   public String placeOrder(@RequestBody OrderRequest orderRequest) {
       return orderService.placeOrder(orderRequest) ;
   }

//   @GetMapping("/all")
//   public List<OrderResponse> fetchAllOrders() {
//       return orderService.fetchAllOrders() ;
//   }

}
