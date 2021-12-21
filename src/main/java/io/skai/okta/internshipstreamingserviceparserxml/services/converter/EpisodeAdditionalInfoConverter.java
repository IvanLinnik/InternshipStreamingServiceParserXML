package io.skai.okta.internshipstreamingserviceparserxml.services.converter;

import io.skai.okta.internshipstreamingserviceparserxml.dto.EpisodeAdditionalInfo;
import io.skai.okta.internshipstreamingserviceparserxml.dto.ImdbJsonItem;
import org.springframework.stereotype.Component;

@Component
public class EpisodeAdditionalInfoConverter {
    public EpisodeAdditionalInfo convert(long episodeId, ImdbJsonItem imdbJsonItem) {
        return EpisodeAdditionalInfo.builder()
                                    .parentId(episodeId)
                                    .imdbID(imdbJsonItem.getImdbID())
                                    .imdbRating(imdbJsonItem.getImdbRating())
                                    .imdbVotes(imdbJsonItem.getImdbVotes())
                                    .runtime(imdbJsonItem.getRuntime())
                                    .seriesID(imdbJsonItem.getSeriesID())
                                    .build();
    }
}
