package io.skai.okta.internshipstreamingserviceparserxml.services;

import io.skai.okta.internshipstreamingserviceparserxml.dto.RssItem;

import java.util.List;

public interface LostFilmService {
    List<RssItem> getItems();
}
