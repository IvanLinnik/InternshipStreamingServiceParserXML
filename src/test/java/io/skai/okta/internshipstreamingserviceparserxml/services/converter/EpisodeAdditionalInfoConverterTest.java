package io.skai.okta.internshipstreamingserviceparserxml.services.converter;

import io.skai.okta.internshipstreamingserviceparserxml.dto.EpisodeAdditionalInfo;
import io.skai.okta.internshipstreamingserviceparserxml.dto.ImdbJsonItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class EpisodeAdditionalInfoConverterTest {
    private EpisodeAdditionalInfo additionalInfo;
    private static final Pattern ID_PATTERN = Pattern.compile("(?<=t{2})\\d+");

    @BeforeEach
    void setUp() {
        EpisodeAdditionalInfoConverter converter = new EpisodeAdditionalInfoConverter();

        ImdbJsonItem item = ImdbJsonItem.builder()
                                        .imdbID("tt1480055")
                                        .seriesID("tt0944947")
                                        .imdbRating("9.1")
                                        .imdbVotes("44868")
                                        .runtime("62 min")
                                        .build();

        additionalInfo = converter.convert(9379992, item);
    }

    @Test
    void testConvertAdditionalInfoShouldBeNotNull() {
        assertNotNull(additionalInfo);
    }

    @Test
    void testConvertAdditionalInfoShouldBeSuccessful() {
        assertEquals(0, additionalInfo.getId());
        assertEquals(9379992, additionalInfo.getParentId());
        assertEquals("tt1480055", additionalInfo.getImdbID());
        assertEquals("tt0944947", additionalInfo.getSeriesID());
        assertEquals("9.1", additionalInfo.getImdbRating());
        assertEquals("44868", additionalInfo.getImdbVotes());
        assertEquals("62 min", additionalInfo.getRuntime());

        assertThat(additionalInfo.getImdbRating()).contains(".");
        assertThat(additionalInfo.getRuntime()).contains(" min");
        assertThat(additionalInfo.getImdbID()).contains("tt").containsPattern(ID_PATTERN);
        assertThat(additionalInfo.getSeriesID()).contains("tt").containsPattern(ID_PATTERN);
    }

}
