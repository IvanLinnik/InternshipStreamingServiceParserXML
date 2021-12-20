package io.skai.okta.internshipstreamingserviceparserxml.services;

import io.skai.okta.internshipstreamingserviceparserxml.dto.LostFilmRssItem;

import java.util.List;

public interface DataParser {

    List<LostFilmRssItem> getNewItems();

}
