package com.kafka.kafka_consumer.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("kafka")
@Data
public class KafkaProperties {

    public static final String CONSUMER_GROUP_ID = "testGroup";
    @Value("${bootstrap-servers}")
    private String bootStrapServers;
}
