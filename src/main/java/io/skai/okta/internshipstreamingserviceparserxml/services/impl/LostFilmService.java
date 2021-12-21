package io.skai.okta.internshipstreamingserviceparserxml.services.impl;

import io.skai.okta.internshipstreamingserviceparserxml.dto.Episode;
import io.skai.okta.internshipstreamingserviceparserxml.kafka.MessageProducer;
import io.skai.okta.internshipstreamingserviceparserxml.repository.VideoRepository;
import io.skai.okta.internshipstreamingserviceparserxml.services.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LostFilmService implements VideoService {
    private final VideoRepository videoRepository;
    private final MessageProducer messageProducer;

    @Override
    public void saveEpisode(Episode episode) {
        videoRepository.saveOrUpdate(episode);
        messageProducer.produce("omdb", episode);
    }

    @Override
    public List<Episode> getAll() {
        return videoRepository.getAll();
    }

    @Override
    public Episode get(String link) {
        return videoRepository.get(link);
    }

}
