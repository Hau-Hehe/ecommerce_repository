package com.haune.ecommerce.kafka.event;

import com.haune.ecommerce.dto.InventoryUpdateEvent;
import com.haune.ecommerce.dto.NotificationEvent;
import com.haune.ecommerce.dto.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class EventProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${app.kafka.topics.order-created}")
    private String orderCreatedTopic;

    @Value("${app.kafka.topics.inventory-update}")
    private String inventoryUpdateTopic;

    @Value("${app.kafka.topics.notification}")
    private String notificationTopic;

    public void sendOrderCreatedEvent(OrderCreatedEvent event) {
        log.info("Sending OrderCreatedEvent for orderId: {}", event.getOrderId());
        kafkaTemplate.send(orderCreatedTopic, event.getOrderId().toString(), event);
    }

    public void sendInventoryUpdateEvent(InventoryUpdateEvent event) {
        log.info("Sending InventoryUpdateEvent for orderId: {}", event.getOrderId());
        kafkaTemplate.send(inventoryUpdateTopic, event.getOrderId().toString(), event);
    }

    public void sendNotificationEvent(NotificationEvent event) {
        log.info("Sending NotificationEvent to: {}", event.getRecipientEmail());
        kafkaTemplate.send(notificationTopic, event.getRecipientEmail(), event);
    }
}
