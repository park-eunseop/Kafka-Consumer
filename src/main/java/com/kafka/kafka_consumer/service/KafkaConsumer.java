package com.kafka.kafka_consumer.service;

import com.kafka.kafka_consumer.config.KafkaProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    //컨슈머를 생성한 다음에 하나 이상의 토픽을 구독(subscribe)해야 한다.
    @KafkaListener(topics = {"exam"}, groupId = KafkaProperties.CONSUMER_GROUP_ID)
    public void consumerMessage(String message,
                                @Header(KafkaHeaders.RECEIVED_TIMESTAMP) Long timestamp,
                                @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                                @Header(KafkaHeaders.OFFSET) Long offset) {
        log.info("Received Message : {}", message);
        log.info("Timestamp : {}", timestamp);
        log.info("Topic : {}", topic);
        log.info("Offset: {}", offset);
    }
}
