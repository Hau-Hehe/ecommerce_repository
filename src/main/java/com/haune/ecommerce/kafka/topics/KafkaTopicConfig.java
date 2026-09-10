package com.haune.ecommerce.kafka.topics;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${app.kafka.topics.order-created}")
    private String orderCreatedTopic;

    @Value("${app.kafka.topics.inventory-update}")
    private String inventoryUpdateTopic;

    @Value("${app.kafka.topics.notification}")
    private String notificationTopic;

    @Bean
    public NewTopic orderCreatedTopic() {
        return TopicBuilder.name(orderCreatedTopic)
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic inventoryUpdateTopic() {
        return TopicBuilder.name(inventoryUpdateTopic)
                .partitions(3)
                .replicas(1)
                .build();
    }

    public NewTopic notificationTopic() {
        return TopicBuilder.name(notificationTopic)
                .partitions(3)
                .replicas(1)
                .build();
    }
}
