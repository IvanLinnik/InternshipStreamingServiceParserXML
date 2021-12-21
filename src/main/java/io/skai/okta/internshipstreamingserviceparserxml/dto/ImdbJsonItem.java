package io.skai.okta.internshipstreamingserviceparserxml.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ImdbJsonItem {

    @JsonProperty(value = "imdbID")
    String imdbID;

    @JsonProperty(value = "seriesID")
    String seriesID;

    @JsonProperty(value = "imdbRating")
    String imdbRating;

    @JsonProperty(value = "imdbVotes")
    String imdbVotes;

    @JsonProperty(value = "Runtime")
    String runtime;

}
