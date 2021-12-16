package io.skai.okta.internshipstreamingserviceparserxml.services.mapper;

import io.skai.okta.internshipstreamingserviceparserxml.dto.Episode;
import io.skai.okta.internshipstreamingserviceparserxml.dto.LostFilmRssItem;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class EpisodesMapper {
    private final Pattern TITLE_PATTERN = Pattern.compile("\\((.*?)\\)");

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
        Matcher matcher = TITLE_PATTERN.matcher(from);

        switch (value) {
            case "season":
                matcher.find();
                matcher.find();
                return matcher.group(1).substring(1, 3);
            case "episode":
                matcher.find();
                matcher.find();
                return matcher.group(1).substring(4, 6);
            case "tvsTitle":
                matcher.find();
                return matcher.group(1);
            default:
                throw new IllegalStateException("Unexpected value: " + value);
        }
    }

}
