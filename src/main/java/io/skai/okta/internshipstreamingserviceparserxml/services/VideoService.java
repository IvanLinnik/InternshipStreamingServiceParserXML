package io.skai.okta.internshipstreamingserviceparserxml.services;

import io.skai.okta.internshipstreamingserviceparserxml.dto.Episode;

import java.util.List;

public interface VideoService {

    void saveEpisode(Episode episode);

    List<Episode> getAll();

    Episode get(String link);

//    void create(LostFilmRssItem lostFilmRssItem);

//    Episode get(Long id);

//    void update(Long id, Video video);

//    void delete(Long id);

}
