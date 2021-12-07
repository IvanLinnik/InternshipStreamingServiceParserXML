package io.skai.okta.internshipstreamingserviceparserxml.services;

import io.skai.okta.internshipstreamingserviceparserxml.dto.Item;
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
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class LostFilmParser {
    //    @Value("${uri}")
    private static final String URI = "https://www.lostfilm.tv/rss.xml";

    //    @Value("${mainTag}")
    private static final String MAIN_TAG = "item";

    LostFilmParser() {
    }

    public List<Item> getItemList() throws ParserConfigurationException, IOException, SAXException {
        Document document = getDocument();
        NodeList nodeList = document.getElementsByTagName(MAIN_TAG);

        return IntStream
                .range(0, nodeList.getLength()).mapToObj(nodeList::item)
                .filter(node -> node.getNodeType() == Node.ELEMENT_NODE)
                .map(this::getItem)
                .collect(Collectors.toList());
    }

    private Document getDocument() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(URI);
        document.getDocumentElement().normalize();
        return document;
    }

    private Item getItem(Node node) {
        Element element = (Element) node;
        return new Item(
                getTagValue("title", element),
                getTagValue("description", element),
                getTagValue("pubDate", element),
                getTagValue("link", element)
        );
    }

    private String getTagValue(String tag, Element element) {
        return element.getElementsByTagName(tag).item(0).getTextContent();
    }

}