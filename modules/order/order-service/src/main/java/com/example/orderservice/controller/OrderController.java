package com.example.orderservice.controller;

import dto.OrderModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController("/order")
public class OrderController {


    @PostMapping("/post-order") // todo will return ORDER DTO
    public void postOrder(@RequestBody OrderModel orderModel){

    }

}
