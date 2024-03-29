package io.skai.okta.internshipstreamingserviceparserxml.repository;

import io.skai.okta.internshipstreamingserviceparserxml.dto.EpisodeAdditionalInfo;
import io.skai.okta.internshipstreamingserviceparserxml.repository.impl.EpisodeAdditionalInfoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class EpisodeAdditionalInfoRepositoryTest {

    @Autowired
    private EpisodeAdditionalInfoRepository repository;

    private final EpisodeAdditionalInfo expectedInfo = EpisodeAdditionalInfo
            .builder()
            .parentId(9379992)
            .imdbID("test imdb id")
            .seriesID("test series id")
            .imdbRating("test imdb rating")
            .imdbVotes("test imdb votes")
            .runtime("test run time")
            .build();

    @Test
    public void testEpisodeSuccessfulSaveAndGet() {
        assertNotNull(repository);

        repository.saveOrUpdate(expectedInfo);
        repository.saveOrUpdate(expectedInfo); //testing invocation method "update" from "saveOrUpdate"
        EpisodeAdditionalInfo actualInfo = repository.findByParentId(expectedInfo.getParentId());

        assertNotNull(actualInfo);
        assertThat(actualInfo).usingRecursiveComparison()
                              .ignoringFields("id")
                              .isEqualTo(expectedInfo);
    }

    @Test
    void getAll() {
        assertThat(repository.getAll()).isNotNull().isNotEmpty();
    }

    @AfterEach
    void tearDown() {
        repository.delete(expectedInfo.getParentId());
    }

}
