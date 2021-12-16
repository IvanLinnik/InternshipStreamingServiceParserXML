package io.skai.okta.internshipstreamingserviceparserxml.services;

import io.skai.okta.internshipstreamingserviceparserxml.dto.Episode;

import java.util.List;

public interface VideoService {

    void saveEpisode(Episode episode);

    List<Episode> getAll();

    Episode get(String link);

}
