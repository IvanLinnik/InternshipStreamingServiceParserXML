package io.skai.okta.internshipstreamingserviceparserxml.dto;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class Episode {

    long id;
    int season;
    int episodeNumber;
//    float imdbRating;

    String tvSeriesTitle;

    @NonNull
    String title;

    @NonNull
    String description;

    @NonNull
    LocalDateTime pubDate;

    @NonNull
    String link;

}
