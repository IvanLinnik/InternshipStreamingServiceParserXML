package io.skai.okta.internshipstreamingserviceparserxml.item;

import io.skai.okta.internshipstreamingserviceparserxml.util.LostFilmParser;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    public List<Item> getItem() {

        List<Item> list = new ArrayList<>();
        try {

            list = LostFilmParser.getItemList();
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return list;
    }

}
