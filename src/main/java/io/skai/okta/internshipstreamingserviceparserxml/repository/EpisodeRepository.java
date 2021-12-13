package io.skai.okta.internshipstreamingserviceparserxml.repository;

import io.skai.okta.internshipstreamingserviceparserxml.dto.Episode;

import java.util.List;
import java.util.Optional;

public interface EpisodeRepository {

    void create(Episode episode);

    List<Episode> getItems();

    Episode getItem(long id);

    Episode getItem(String link);

    void update(Episode episode);

    void delete(long id);

    void delete(String link);

    Optional<Long> getId(String link);
}
