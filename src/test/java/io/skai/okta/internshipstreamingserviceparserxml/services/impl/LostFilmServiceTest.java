package io.skai.okta.internshipstreamingserviceparserxml.services.impl;

import io.skai.okta.internshipstreamingserviceparserxml.dto.Episode;
import io.skai.okta.internshipstreamingserviceparserxml.kafka.MessageProducer;
import io.skai.okta.internshipstreamingserviceparserxml.repository.VideoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class LostFilmServiceTest {

    @InjectMocks
    LostFilmService service;

    @Mock
    private VideoRepository repository;

    @Mock
    private MessageProducer producer;

    private final Episode episode = Episode
            .builder()
            .title("test title")
            .description("test description")
            .pubDate(LocalDateTime.parse("Sun, 19 Dec 2021 18:50:04 +0000",
                    DateTimeFormatter.ofPattern("E, d MMM yyyy HH:mm:ss Z")))
            .link("test link")
            .season(1)
            .episodeNumber(1)
            .tvSeriesTitle("test tv series title")
            .build();

    @Test
    void testSaveEpisodeSuccessful() {
        service.saveEpisode(episode);
        verify(repository).saveOrUpdate(episode);
        verify(producer).produce(eq("omdb"), eq(episode));
    }

    @Test
    void testSaveEmptyEpisodeShouldThrowException() {
        assertThrows(NullPointerException.class,
                () -> service.saveEpisode(Episode.builder().build()));
    }

    @Test
    void testGetAllSuccessful() {
        service.getAll();
        verify(repository).getAll();
    }

    @Test
    void testGetSuccessful() {
        service.get(episode.getLink());
        verify(repository).findByLink(episode.getLink());
    }

    @Test
    void testGetEmptyEpisodeShouldThrowException() {
        assertThrows(NullPointerException.class,
                () -> service.get(Episode.builder().build().getLink()));
    }

}
