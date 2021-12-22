package io.skai.okta.internshipstreamingserviceparserxml.repository;

import io.skai.okta.internshipstreamingserviceparserxml.dto.Episode;
import io.skai.okta.internshipstreamingserviceparserxml.repository.impl.EpisodeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

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
    public void testEpisodeCanSaveAndRead() {
        Episode episode = Episode.builder()
                                 .title("testTitle")
                                 .description("testDescription")
                                 .pubDate(LocalDateTime.now())
                                 .link("testLink")
                                 .season(1)
                                 .episodeNumber(1)
                                 .tvSeriesTitle("test tv series title")
                                 .build();

        episodeRepository.saveOrUpdate(episode);

        assertNotNull(episodeRepository.get("testLink"));
    }

    @Test
    public void testGetAll() {
        List<Episode> episodes = episodeRepository.getAll();
        assertThat(episodes).size().isGreaterThan(41);
    }

}
