package io.skai.okta.internshipstreamingserviceparserxml.kafka;

import io.skai.okta.internshipstreamingserviceparserxml.dto.Episode;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageProducer {
    KafkaTemplate<String, Episode> kafkaTemplate;

    @KafkaHandler
    public void produce(String topic, Episode message) {
        kafkaTemplate.send(topic, message);
    }

}
