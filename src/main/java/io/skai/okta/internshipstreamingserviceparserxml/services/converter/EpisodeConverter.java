package io.skai.okta.internshipstreamingserviceparserxml.services.converter;

import io.skai.okta.internshipstreamingserviceparserxml.dto.Episode;
import io.skai.okta.internshipstreamingserviceparserxml.dto.LostFilmRssItem;
import org.springframework.stereotype.Component;

@Component
public class EpisodeConverter {
    public Episode map(LostFilmRssItem lostFilmRssItem) {
        String title = lostFilmRssItem.getTitle();
        int season = Integer.parseInt(extract(title, "season"));
        int episodeNumber = Integer.parseInt(extract(title, "episode"));
        String tvSeriesTitle = extract(title, "tvsTitle");

        return Episode.builder()
                      .season(season)
                      .episodeNumber(episodeNumber)
                      .tvSeriesTitle(tvSeriesTitle)
                      .title(title)
                      .description(lostFilmRssItem.getDescription())
                      .pubDate(lostFilmRssItem.getPubDate())
                      .link(lostFilmRssItem.getLink())
                      .build();
    }

    private String extract(String from, String value) {
        final String[] result = from.replaceAll("\\(", ")").split("\\)");
        switch (value) {
            case "tvsTitle":
                return result[1];
            case "season":
                return result[3].substring(1, 3);
            case "episode":
                return result[3].substring(4, 6);
            default:
                throw new IllegalStateException("Unexpected value: " + value);
        }
    }

}
