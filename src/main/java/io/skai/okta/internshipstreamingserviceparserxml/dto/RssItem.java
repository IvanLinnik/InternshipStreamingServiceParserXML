package io.skai.okta.internshipstreamingserviceparserxml.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RssItem {
    private String title;
    private String description;
    private String pubDate;
    private String link;
}
