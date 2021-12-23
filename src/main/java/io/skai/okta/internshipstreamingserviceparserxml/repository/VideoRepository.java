package io.skai.okta.internshipstreamingserviceparserxml.repository;

import io.skai.okta.internshipstreamingserviceparserxml.dto.Episode;

import java.util.List;
import java.util.Optional;

public interface VideoRepository {

    void saveOrUpdate(Episode episode);

    void save(Episode episode);

    List<Episode> getAll();

    Episode findByLink(String link);

    void update(Episode episode);

    Optional<Long> getId(String link);

    void delete(String link);
}
