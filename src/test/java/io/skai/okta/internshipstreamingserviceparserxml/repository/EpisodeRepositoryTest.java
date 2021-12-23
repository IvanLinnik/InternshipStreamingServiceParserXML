package io.skai.okta.internshipstreamingserviceparserxml.repository;

import io.skai.okta.internshipstreamingserviceparserxml.dto.Episode;
import io.skai.okta.internshipstreamingserviceparserxml.repository.impl.EpisodeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
    private EpisodeRepository repository;

    private Episode expectedEpisode;

    @BeforeEach
    void setUp() {
        expectedEpisode = Episode.builder()
                                 .title("test title")
                                 .description("test description")
                                 .pubDate(LocalDateTime.parse("Sun, 19 Dec 2021 18:50:04 +0000",
                                         DateTimeFormatter.ofPattern("E, d MMM yyyy HH:mm:ss Z")))
                                 .link("test link")
                                 .season(1)
                                 .episodeNumber(1)
                                 .tvSeriesTitle("test tv series title")
                                 .build();
    }

    @Test
    public void testRepositoryShouldBeNotNull() {
        assertNotNull(repository);
    }

    @Test
    public void testEpisodeSuccessfulSaveAndGet() {
        repository.saveOrUpdate(expectedEpisode);
        Episode actualEpisode = repository.get("test link");

        assertNotNull(actualEpisode);
        assertThat(actualEpisode).usingRecursiveComparison()
                                 .ignoringFields("id")
                                 .isEqualTo(expectedEpisode);
    }

    @Test
    void getAll() {
        assertThat(repository.getAll()).isNotNull().isNotEmpty();
    }

    @AfterEach
    void tearDown() {
        repository.delete(expectedEpisode.getLink());
    }

}
