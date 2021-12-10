package io.skai.okta.internshipstreamingserviceparserxml.services;

import io.skai.okta.internshipstreamingserviceparserxml.dto.RssItem;
import lombok.RequiredArgsConstructor;
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
class LostFilmParser {
    @Value("${lostfilm.rss.url}")
    private final String url;

    @Value("${lostfilm.rss.tag}")
    private final String lostfilmRssTag;

    public List<RssItem> getItemList() throws ParserConfigurationException, IOException, SAXException {
        Document document = getDocument();
        NodeList nodeList = document.getElementsByTagName(lostfilmRssTag);

        return IntStream
                .range(0, nodeList.getLength()).mapToObj(nodeList::item)
                .filter(node -> node.getNodeType() == Node.ELEMENT_NODE)
                .map(this::getItem)
                .collect(Collectors.toList());
    }

    private Document getDocument() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(url);
        document.getDocumentElement().normalize();
        return document;
    }

    private RssItem getItem(Node node) {
        Element element = (Element) node;
        return new RssItem(
                getTagValue("title", element),
                getTagValue("description", element),
                LocalDateTime.parse(getTagValue("pubDate", element),
                        DateTimeFormatter.ofPattern("E, d MMM yyyy HH:mm:ss Z")),
                getTagValue("link", element)
        );
    }

    private String getTagValue(String tag, Element element) {
        return element.getElementsByTagName(tag).item(0).getTextContent();
    }

}
