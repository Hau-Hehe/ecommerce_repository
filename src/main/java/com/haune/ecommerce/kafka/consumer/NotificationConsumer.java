package com.haune.ecommerce.kafka.consumer;

import com.haune.ecommerce.dto.NotificationEvent;
import com.haune.ecommerce.dto.OrderCreatedEvent;
import com.haune.ecommerce.kafka.event.EventProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {
    private final EventProducer eventProducer;

    @KafkaListener(
            topics = "${app.kafka.topics.order-created}",
            groupId = "notification-order-group"
    )
    public void handleOrderCreatedForNotification(OrderCreatedEvent event) {
        log.info("Triggering order confirmation notification dor email: {}", event.getUserEmail());

        NotificationEvent notification = NotificationEvent.builder()
                .recipientEmail(event.getUserEmail())
                .subject("Xác nận đơn hàng #" + event.getOrderId())
                .templateName("order-confirmation-template")
                .payload(Map.of(
                        "orderId", event.getOrderId(),
                        "totalAmount", event.getTotalAmount()
                ))
                .build();
        eventProducer.sendNotificationEvent(notification);
    }

    @KafkaListener(
            topics = "${app.kafka.topics.notification}",
            groupId = "mail-service-group"
    )
    public void consumeNotification(NotificationEvent event) {
        log.info("Processing mail sending to : {} | Subject: {}",
                event.getRecipientEmail(), event.getSubject());
    }
}
