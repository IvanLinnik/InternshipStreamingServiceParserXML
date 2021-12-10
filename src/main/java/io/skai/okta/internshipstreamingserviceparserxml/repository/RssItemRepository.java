package io.skai.okta.internshipstreamingserviceparserxml.repository;

import io.skai.okta.internshipstreamingserviceparserxml.dto.RssItem;

import java.util.List;
import java.util.Optional;

public interface RssItemRepository {

    void create(RssItem rssItem);

    List<RssItem> getItems();

    RssItem getItem(long id);

    RssItem getItem(String link);

    void update(RssItem rssItem);

    void delete(long id);

    void delete(String link);

    Optional<Long> getId(String link);
}
