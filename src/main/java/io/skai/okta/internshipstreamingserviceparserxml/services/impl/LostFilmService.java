package io.skai.okta.internshipstreamingserviceparserxml.services.impl;

import io.skai.okta.internshipstreamingserviceparserxml.dto.Episode;
import io.skai.okta.internshipstreamingserviceparserxml.repository.VideoRepository;
import io.skai.okta.internshipstreamingserviceparserxml.services.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LostFilmService implements VideoService {
    private final VideoRepository videoRepository;

    @Override
    public void saveEpisode(Episode episode) {
        videoRepository.saveOrUpdate(episode);
    }

    @Override
    public List<Episode> getAll() {
        return videoRepository.getAll();
    }

    @Override
    public Episode get(String link) {
        return videoRepository.get(link);
    }

//    @Override
//    public void create(LostFilmRssItem lostFilmRssItem) {
//        videoRepository.saveOrUpdate(lostFilmRssItem);
//    }

//    @Override
//    public Episode get(Long id) {
//        return videoRepository.get(id);
//    }

//    @Override
//    public void update(Long id, Episode episode) {
//        videoRepository.update(episode);
//    }

//    @Override
//    public void delete(Long id) {
//        videoRepository.delete(id);
//    }

//    @Override
//    public void delete(String link) {
//        videoRepository.delete(link);
//    }

//    private List<Video> getNewItems() {
//        return dataParser.getVideosList();
//    }

}
