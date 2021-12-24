package io.skai.okta.internshipstreamingserviceparserxml.services.impl;

import io.skai.okta.internshipstreamingserviceparserxml.dto.LostFilmRssItem;
import io.skai.okta.internshipstreamingserviceparserxml.services.DataParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
@Slf4j
class XmlParserLostFilm implements DataParser {
    @Value("${lostfilm.rss.url}")
    private final String url;

    @Value("${lostfilm.rss.tag}")
    private final String lostFilmRssTag;

    @Override
    public List<LostFilmRssItem> getNewItems() {
        Document document = getDocument();
        NodeList nodeList = document.getElementsByTagName(lostFilmRssTag);

        return IntStream.range(0, nodeList.getLength()).mapToObj(nodeList::item)
                        .filter(node -> node.getNodeType() == Node.ELEMENT_NODE)
                        .map(this::getItem)
                        .collect(Collectors.toList());
    }

    private Document getDocument() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            log.error("Error in build document method: ", e);
        }
        Document document = null;
        try {
            document = builder.parse(url);
        } catch (SAXException | IOException e) {
            log.error("Error in URL parse method: " + e);
        }
        document.getDocumentElement().normalize();
        return document;
    }

    private LostFilmRssItem getItem(Node node) {
        Element element = (Element) node;

        String title = getTagValue("title", element);
        String description = getTagValue("description", element);
        LocalDateTime pubDate = LocalDateTime.parse(getTagValue("pubDate", element),
                DateTimeFormatter.ofPattern("E, d MMM yyyy HH:mm:ss Z"));
        String link = getTagValue("link", element);

        return LostFilmRssItem.builder()
                              .title(title)
                              .description(description)
                              .pubDate(pubDate)
                              .link(link)
                              .build();
    }

    private String getTagValue(String tag, Element element) {
        return element.getElementsByTagName(tag).item(0).getTextContent();
    }

}
