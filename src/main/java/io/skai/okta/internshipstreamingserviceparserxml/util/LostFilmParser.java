package io.skai.okta.internshipstreamingserviceparserxml.util;

import io.skai.okta.internshipstreamingserviceparserxml.item.Item;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LostFilmParser {
    private static final String URI = "https://www.lostfilm.tv/rss.xml";
    private static final String MAIN_TAG = "item";

    private LostFilmParser() {
    }

    public static List<Item> getItemList() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(URI);
        document.getDocumentElement().normalize();

        NodeList nodeList = document.getElementsByTagName(MAIN_TAG);
        List<Item> itemList = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            itemList.add(getItem(nodeList.item(i)));
        }

        return itemList;
    }

    private static Item getItem(Node node) {
        Item item = new Item();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            item.setTitle(getTagValue("title", element));
            item.setDescription(getTagValue("description", element));
            item.setPubDate(getTagValue("pubDate", element));
            item.setLink(getTagValue("link", element));
        }
        return item;
    }

    private static String getTagValue(String tag, Element element) {
        return element.getElementsByTagName(tag).item(0).getTextContent();
    }

}