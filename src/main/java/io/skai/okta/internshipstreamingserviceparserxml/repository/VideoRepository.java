package io.skai.okta.internshipstreamingserviceparserxml.repository;

import io.skai.okta.internshipstreamingserviceparserxml.dto.Episode;

import java.util.List;
import java.util.Optional;

public interface VideoRepository {

    void saveOrUpdate(Episode episode);

    void save(Episode episode);

    List<Episode> getAll();

    Episode get(String link);

    void update(Episode episode);

    Optional<Long> getId(String link);

//    Episode get(long id);

//    void delete(long id);

//    void delete(String link);

}
