package io.skai.okta.internshipstreamingserviceparserxml.services.impl;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;

@WireMockTest
@SpringBootTest
@AutoConfigureWireMock(port = 0)
class XmlParserLostFilmTest {

    @Autowired
    XmlParserLostFilm parser;

    @Test
    void testGetNewItems() {
        stubFor(get(urlEqualTo("/www.lostfilm.tv/rss.xml"))
                .willReturn(okXml("rss.xml")));

        assertThat(parser.getNewItems()).isNotNull().isNotEmpty();
    }

}
