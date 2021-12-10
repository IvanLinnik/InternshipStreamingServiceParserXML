package io.skai.okta.internshipstreamingserviceparserxml.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RssItem {
    private String title;
    private String description;
    private LocalDateTime pubDate;
    private String link;
}
