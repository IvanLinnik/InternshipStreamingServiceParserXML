package io.skai.okta.internshipstreamingserviceparserxml.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class EpisodeAdditionalInfo {

    long id;

    long parentId;

    String imdbID;

    String seriesID;

    String imdbRating;

    String imdbVotes;

    String runtime;

}
