package io.skai.okta.internshipstreamingserviceparserxml.services;

import io.skai.okta.internshipstreamingserviceparserxml.dto.RssItem;

import java.util.List;

public interface LostFilmService {
    void createItem(RssItem rssItem);

    void createNewItems();

    List<RssItem> getItems();

    RssItem getItem(Long id);

    RssItem getItem(String link);

    void update(Long id, RssItem rssItem);

    void delete(Long id);

    void delete(String link);
}
