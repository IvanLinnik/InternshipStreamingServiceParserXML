package io.skai.okta.internshipstreamingserviceparserxml.services;

import io.skai.okta.internshipstreamingserviceparserxml.dto.Episode;

import java.util.List;

public interface LostFilmService {

    void createEpisode(Episode episode);

    void createNewEpisodes();

    List<Episode> getEpisodes();

    Episode getEpisode(Long id);

    Episode getEpisode(String link);

    void updateEpisode(Long id, Episode episode);

    void deleteEpisode(Long id);

    void deleteEpisode(String link);

}
