package io.skai.okta.internshipstreamingserviceparserxml.kafka;

import io.skai.okta.internshipstreamingserviceparserxml.controllers.OmdbController;
import io.skai.okta.internshipstreamingserviceparserxml.dto.Episode;
import io.skai.okta.internshipstreamingserviceparserxml.dto.ImdbJsonItem;
import io.skai.okta.internshipstreamingserviceparserxml.repository.impl.EpisodeAdditionalInfoRepository;
import io.skai.okta.internshipstreamingserviceparserxml.services.converter.EpisodeAdditionalInfoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageConsumer {
    @Value("${omdb.my.apiKey}")
    private final String apiKey;
    private final OmdbController omdbController;
    private final EpisodeAdditionalInfoConverter episodeAdditionalInfoConverter;
    private final EpisodeAdditionalInfoRepository episodeAdditionalInfoRepository;

    @KafkaListener(topics = "omdb")
    public void consume(Episode episode) {
        ImdbJsonItem imdbJsonItem = omdbController.getAdditionalInfo(apiKey,
                episode.getTvSeriesTitle(),
                episode.getSeason(),
                episode.getEpisodeNumber());

        episodeAdditionalInfoRepository.saveOrUpdate(episodeAdditionalInfoConverter.convert(episode.getId(), imdbJsonItem));
    }

}
