package io.skai.okta.internshipstreamingserviceparserxml.services.converter;

import io.skai.okta.internshipstreamingserviceparserxml.dto.EpisodeAdditionalInfo;
import io.skai.okta.internshipstreamingserviceparserxml.dto.ImdbJsonItem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class EpisodeAdditionalInfoConverterTest {

    @InjectMocks
    EpisodeAdditionalInfoConverter converter;

    private final ImdbJsonItem item = ImdbJsonItem.builder()
                                                  .imdbID("tt1480055")
                                                  .seriesID("tt0944947")
                                                  .imdbRating("9.1")
                                                  .imdbVotes("44868")
                                                  .runtime("62 min")
                                                  .build();

    private static final Pattern ID_PATTERN = Pattern.compile("(?<=t{2})\\d+");

    @Test
    void testConvertAdditionalInfoShouldBeSuccessful() {
        EpisodeAdditionalInfo info = converter.convert(9379992, item);

        assertNotNull(info);

        assertEquals(0, info.getId());
        assertEquals(9379992, info.getParentId());
        assertEquals("tt1480055", info.getImdbID());
        assertEquals("tt0944947", info.getSeriesID());
        assertEquals("9.1", info.getImdbRating());
        assertEquals("44868", info.getImdbVotes());
        assertEquals("62 min", info.getRuntime());

        assertThat(info.getImdbRating()).contains(".");
        assertThat(info.getRuntime()).contains(" min");
        assertThat(info.getImdbID()).contains("tt").containsPattern(ID_PATTERN);
        assertThat(info.getSeriesID()).contains("tt").containsPattern(ID_PATTERN);
    }

}
