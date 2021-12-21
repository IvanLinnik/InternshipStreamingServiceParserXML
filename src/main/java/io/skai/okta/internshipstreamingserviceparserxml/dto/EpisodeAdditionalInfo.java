package io.skai.okta.internshipstreamingserviceparserxml.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class EpisodeAdditionalInfo {

    long id;

    String imdbID;

    String seriesID;

    String imdbRating;

    String imdbVotes;

    String runtime;

}
