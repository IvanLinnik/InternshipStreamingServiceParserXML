package io.skai.okta.internshipstreamingserviceparserxml.services.converter;

import io.skai.okta.internshipstreamingserviceparserxml.dto.Episode;
import io.skai.okta.internshipstreamingserviceparserxml.dto.LostFilmRssItem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.security.InvalidParameterException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EpisodeConverterTest {

    @InjectMocks
    private EpisodeConverter converter;

    private final LostFilmRssItem item = LostFilmRssItem
            .builder()
            .title("Ведьмак (The Witcher). Крупица истины. (S02E01)")
            .description("![CDATA[<img src=\"//static.lostfilm.top/Images/466/Posters/image.jpg\" alt=\"\" /><br />]]")
            .pubDate(LocalDateTime.parse("Sun, 19 Dec 2021 20:57:00 +0000",
                    DateTimeFormatter.ofPattern("E, d MMM yyyy HH:mm:ss Z")))
            .link("https://www.lostfilmtv1.site/mr/series/The_Witcher/season_2/episode_1/")
            .build();

    @Test
    void testConvertShouldBeSuccessful() {
        Episode episode = converter.convert(item);

        assertNotNull(episode);

        assertEquals(0, episode.getId());
        assertEquals("Ведьмак (The Witcher). Крупица истины. (S02E01)", episode.getTitle());
        assertEquals("![CDATA[<img src=\"//static.lostfilm.top/Images/466/Posters/image.jpg\" alt=\"\" /><br />]]", episode.getDescription());
        assertEquals(LocalDateTime.parse("Sun, 19 Dec 2021 20:57:00 +0000",
                DateTimeFormatter.ofPattern("E, d MMM yyyy HH:mm:ss Z")), episode.getPubDate());
        assertEquals("https://www.lostfilmtv1.site/mr/series/The_Witcher/season_2/episode_1/", episode.getLink());
        assertEquals(2, episode.getSeason());
        assertEquals(1, episode.getEpisodeNumber());
        assertEquals("The Witcher", episode.getTvSeriesTitle());

        assertThat(episode.getTitle()).contains(".").containsAnyOf("(", ")", "S", "E", ".");
        assertThat(episode.getDescription()).containsAnyOf("lostfilm", "image", ".");
    }

    @Test
    void testConvertShouldThrowException() {
        LostFilmRssItem wrongFormatOfTitleItem = LostFilmRssItem.builder()
                                                                .title("WRONG FORMAT OF TITLE")
                                                                .description(item.getDescription())
                                                                .pubDate(item.getPubDate())
                                                                .link(item.getLink())
                                                                .build();

        assertThrows(InvalidParameterException.class, () -> converter.convert(wrongFormatOfTitleItem));
    }

}
