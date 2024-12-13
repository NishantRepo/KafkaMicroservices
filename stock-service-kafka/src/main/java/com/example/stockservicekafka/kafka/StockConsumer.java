package com.example.stockservicekafka.kafka;

import com.example.basedomainservicekafka.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class StockConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(StockConsumer.class);

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent event) {

        LOGGER.info("Order event received in stock service =>> {}", event.toString());
        /*
        TODO
        save order data into database...
        */

    }
}
