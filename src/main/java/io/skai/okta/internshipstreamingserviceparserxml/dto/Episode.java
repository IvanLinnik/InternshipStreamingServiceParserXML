package io.skai.okta.internshipstreamingserviceparserxml.dto;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class Episode {
    @NonNull
    String title;
    @NonNull
    String description;
    @NonNull
    LocalDateTime pubDate;
    @NonNull
    String link;
}
