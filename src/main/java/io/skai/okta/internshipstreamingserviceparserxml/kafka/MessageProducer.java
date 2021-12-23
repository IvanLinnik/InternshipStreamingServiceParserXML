package io.skai.okta.internshipstreamingserviceparserxml.kafka;

import io.skai.okta.internshipstreamingserviceparserxml.dto.Episode;
import io.skai.okta.internshipstreamingserviceparserxml.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageProducer {
    private final KafkaTemplate<String, Episode> kafkaTemplate;
    private final VideoRepository videoRepository;

    @KafkaHandler
    public void produce(String topic, Episode episode) {
        kafkaTemplate.send(topic, videoRepository.findByLink(episode.getLink()));
    }

}
