package com.haune.ecommerce.kafka.consumer;

import com.haune.ecommerce.dto.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class InventoryConsumer {

    @KafkaListener(
            topics = "${app.kafka.topics.order-created}",
            groupId = "inventory-group"
    )
    public void consumerOrderCreated(OrderCreatedEvent event) {
        log.info("Received OrderCreatedEvent in InventoryConsumer for orderId: {}", event.getOrderId());

        event.getItems().forEach(item -> {
            log.info("Deducting productItemId: {} with qty: {}",
                    item.getProductItemId(), item.getQuantity());
        });
    }
}
