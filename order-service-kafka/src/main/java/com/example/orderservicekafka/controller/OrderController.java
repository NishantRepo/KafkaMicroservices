package com.example.orderservicekafka.controller;

import com.example.basedomainservicekafka.dto.Order;
import com.example.basedomainservicekafka.dto.OrderEvent;
import com.example.orderservicekafka.kafka.OrderProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderProducer producer;

    @PostMapping("/orders")
    public String createOrder(@RequestBody Order order) {
        LOGGER.info("Request received in order controller.");
        order.setOrderId(UUID.randomUUID().toString());

        OrderEvent orderEvent = OrderEvent.builder()
                .status("PENDING")
                .message("Order status is in pending state.")
                .order(order)
                .build();

        producer.sendMessage(orderEvent);
        return "Order placed Successfully...";

    }
}
