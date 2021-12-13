package io.skai.okta.internshipstreamingserviceparserxml.services.impl;

import io.skai.okta.internshipstreamingserviceparserxml.dto.Episode;
import io.skai.okta.internshipstreamingserviceparserxml.repository.EpisodeRepository;
import io.skai.okta.internshipstreamingserviceparserxml.services.LostFilmParser;
import io.skai.okta.internshipstreamingserviceparserxml.services.LostFilmService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LostFilmServiceImpl implements LostFilmService {
    private final EpisodeRepository episodeRepository;
    private final LostFilmParser lostFilmParser;

    @Override
    public void createEpisode(Episode episode) {
        episodeRepository.create(episode);
    }

    @Override
    public void createNewEpisodes() {
        getNewItems().forEach(episodeRepository::create);
    }

    @Override
    public List<Episode> getEpisodes() {
        return episodeRepository.getItems();
    }

    @Override
    public Episode getEpisode(Long id) {
        return episodeRepository.getItem(id);
    }

    @Override
    public Episode getEpisode(String link) {
        return episodeRepository.getItem(link);
    }

    @Override
    public void updateEpisode(Long id, Episode episode) {
        episodeRepository.update(episode);
    }

    @Override
    public void deleteEpisode(Long id) {
        episodeRepository.delete(id);
    }

    @Override
    public void deleteEpisode(String link) {
        episodeRepository.delete(link);
    }

    private List<Episode> getNewItems() {
        return lostFilmParser.getItemList();
    }

}
