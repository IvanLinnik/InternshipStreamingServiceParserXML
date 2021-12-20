package io.skai.okta.internshipstreamingserviceparserxml.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @KafkaListener
    public void consume() {

    }

}
