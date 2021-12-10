package io.skai.okta.internshipstreamingserviceparserxml.services;

import io.skai.okta.internshipstreamingserviceparserxml.dto.RssItem;
import io.skai.okta.internshipstreamingserviceparserxml.repository.RssItemRepository;
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
    private final RssItemRepository rssItemRepository;
    private final LostFilmParser parser;

    @Override
    public void createItem(RssItem rssItem) {
        rssItemRepository.create(rssItem);
    }

    @Override
    public void createNewItems() {
        getNewItems().forEach(rssItemRepository::create);
    }

    @Override
    public List<RssItem> getItems() {
        return rssItemRepository.getItems();
    }

    @Override
    public RssItem getItem(Long id) {
        return rssItemRepository.getItem(id);
    }

    @Override
    public RssItem getItem(String link) {
        return rssItemRepository.getItem(link);
    }

    @Override
    public void update(Long id, RssItem rssItem) {
        rssItemRepository.update(rssItem);
    }

    @Override
    public void delete(Long id) {
        rssItemRepository.delete(id);
    }

    @Override
    public void delete(String link) {
        rssItemRepository.delete(link);
    }

    private List<RssItem> getNewItems() {
        try {
            return parser.getItemList();
        } catch (ParserConfigurationException | IOException | SAXException e) {
            log.error("", e);
        }
        return List.of();
    }

}
