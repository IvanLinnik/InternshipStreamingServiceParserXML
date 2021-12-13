package io.skai.okta.internshipstreamingserviceparserxml.services;

import io.skai.okta.internshipstreamingserviceparserxml.dto.Episode;

import java.time.LocalDateTime;

public interface EpisodesConverter {

    String getTitle(Episode episode);

    String getDescription(Episode episode);

    LocalDateTime getPubDate(Episode episode);

    String getLink(Episode episode);

}
