package io.skai.okta.internshipstreamingserviceparserxml.services.converter;

import io.skai.okta.internshipstreamingserviceparserxml.dto.Episode;
import io.skai.okta.internshipstreamingserviceparserxml.dto.LostFilmRssItem;
import org.springframework.stereotype.Component;

import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class EpisodeConverter {
    private final static Pattern TVS_TITLE_PATTERN = Pattern.compile("(?<=\\().+?(?=\\))");
    private final static Pattern SEASON_NUMBER_PATTERN = Pattern.compile("(?<=\\(S)\\d{2}(?=E\\d{2})");
    private final static Pattern EPISODE_NUMBER_PATTERN = Pattern.compile("(?<=\\(S\\d{2}E)\\d{2}(?=\\))");

    public Episode map(LostFilmRssItem lostFilmRssItem) {
        String title = lostFilmRssItem.getTitle();

        String tvSeriesTitle = extract(title, EpisodeField.TV_SERIES_TITLE);
        int seasonNumber = Integer.parseInt(extract(title, EpisodeField.SEASON_NUMBER));
        int episodeNumber = Integer.parseInt(extract(title, EpisodeField.EPISODE_NUMBER));

        return Episode.builder()
                      .season(seasonNumber)
                      .episodeNumber(episodeNumber)
                      .tvSeriesTitle(tvSeriesTitle)
                      .title(title)
                      .description(lostFilmRssItem.getDescription())
                      .pubDate(lostFilmRssItem.getPubDate())
                      .link(lostFilmRssItem.getLink())
                      .build();
    }

    private String extract(String from, EpisodeField field) {
        switch (field) {
            case TV_SERIES_TITLE:
                return extractField(from, TVS_TITLE_PATTERN);
            case SEASON_NUMBER:
                return extractField(from, SEASON_NUMBER_PATTERN);
            case EPISODE_NUMBER:
                return extractField(from, EPISODE_NUMBER_PATTERN);
            default:
                throw new IllegalStateException("Unexpected field: " + field);
        }
    }

    private String extractField(String from, Pattern pattern) {
        Matcher matcher = pattern.matcher(from);
        if (matcher.find()) {
            return matcher.group(0);
        }
        throw new InvalidParameterException("Format of \"title\" string is illegal");
    }

    private enum EpisodeField {
        TV_SERIES_TITLE,
        SEASON_NUMBER,
        EPISODE_NUMBER
    }

}
