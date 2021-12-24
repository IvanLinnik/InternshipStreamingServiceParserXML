package io.skai.okta.internshipstreamingserviceparserxml.services.impl;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import io.skai.okta.internshipstreamingserviceparserxml.dto.LostFilmRssItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;

@WireMockTest
@SpringBootTest
@AutoConfigureWireMock(port = 8089)
class XmlParserLostFilmTest {

    @Autowired
    XmlParserLostFilm parser;

    private final LostFilmRssItem item = LostFilmRssItem
            .builder()
            .title("1883 (1883). 1883. (S01E01)")
            .description("<img src=\"//static.lostfilm.top/Images/634/Posters/image.jpg\" alt=\"\" /><br />")
            .pubDate(LocalDateTime.parse("Tue, 21 Dec 2021 20:59:00 +0000",
                    DateTimeFormatter.ofPattern("E, d MMM yyyy HH:mm:ss Z")))
            .link("https://www.lostfilmtv1.site/mr/series/1883/season_1/episode_1/")
            .build();

    @Test
    void testGetNewItemsSuccessful() {
        stubFor(get(urlEqualTo("/www.lostfilm.tv/rss.xml"))
                .willReturn(okXml("rss.xml")));

        assertThat(parser.getNewItems()).isNotNull()
                                        .isNotEmpty()
                                        .contains(item);
    }

}
