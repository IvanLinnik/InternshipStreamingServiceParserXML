package io.skai.okta.internshipstreamingserviceparserxml.services.impl;

import io.skai.okta.internshipstreamingserviceparserxml.dto.Episode;
import io.skai.okta.internshipstreamingserviceparserxml.services.EpisodesConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class EpisodesConverterImpl implements EpisodesConverter {

    @Override
    public String getTitle(Episode episode) {
        return episode.getTitle();
    }

    @Override
    public String getDescription(Episode episode) {
        return episode.getDescription();
    }

    @Override
    public LocalDateTime getPubDate(Episode episode) {
        return episode.getPubDate();
    }

    @Override
    public String getLink(Episode episode) {
        return episode.getLink();
    }
}
