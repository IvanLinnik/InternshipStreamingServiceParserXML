package io.skai.okta.internshipstreamingserviceparserxml.services;

import io.skai.okta.internshipstreamingserviceparserxml.dto.RssItem;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class LostFilmServiceImpl implements LostFilmService {
    private final LostFilmParser parser;

    @Override
    public List<RssItem> getItems() {
        try {
            return parser.getItemList();
        } catch (ParserConfigurationException | IOException | SAXException e) {
            log.error("", e);
        }
        return List.of();
    }
}