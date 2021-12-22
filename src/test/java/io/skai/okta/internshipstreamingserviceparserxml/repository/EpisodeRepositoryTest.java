package io.skai.okta.internshipstreamingserviceparserxml.repository;

import io.skai.okta.internshipstreamingserviceparserxml.dto.Episode;
import io.skai.okta.internshipstreamingserviceparserxml.repository.impl.EpisodeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class EpisodeRepositoryTest {

    @Autowired
    private EpisodeRepository episodeRepository;

    @Test
    public void testRepositoryShouldBeNotNull() {
        assertNotNull(episodeRepository);
    }

    @Test
    public void testEpisodeSuccessfulSaveAndGet() {
        Episode expectedEpisode = Episode.builder()
                                         .title("testTitle")
                                         .description("testDescription")
                                         .pubDate(LocalDateTime.parse("Sun, 19 Dec 2021 18:50:04 +0000",
                                                 DateTimeFormatter.ofPattern("E, d MMM yyyy HH:mm:ss Z")))
                                         .link("testLink")
                                         .season(1)
                                         .episodeNumber(1)
                                         .tvSeriesTitle("test tv series title")
                                         .build();

        episodeRepository.saveOrUpdate(expectedEpisode);
        Episode actualEpisode = episodeRepository.get("testLink");

        assertNotNull(actualEpisode);
        assertThat(actualEpisode).usingRecursiveComparison()
                                 .ignoringFields("id")
                                 .isEqualTo(expectedEpisode);
    }

}
