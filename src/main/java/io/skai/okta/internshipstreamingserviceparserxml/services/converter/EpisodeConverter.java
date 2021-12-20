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
    private final static Pattern SEASON_PATTERN = Pattern.compile("(?<=\\(S)\\d{2}(?=E\\d{2})");
    private final static Pattern EPISODE_PATTERN = Pattern.compile("(?<=\\(S\\d{2}E)\\d{2}(?=\\))");

    public Episode map(LostFilmRssItem lostFilmRssItem) {
        String title = lostFilmRssItem.getTitle();

        String tvSeriesTitle = extract(title, "tvsTitle");
        int season = Integer.parseInt(extract(title, "season"));
        int episodeNumber = Integer.parseInt(extract(title, "episode"));

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
        switch (value) {
            case "tvsTitle":
                return extractTvsTitle(from);
            case "season":
                return extractSeason(from);
            case "episode":
                return extractEpisode(from);
            default:
                throw new IllegalStateException("Unexpected value: " + value);
        }
    }

    private String extractTvsTitle(String from) {
        Matcher matcher = TVS_TITLE_PATTERN.matcher(from);
        if (matcher.find()) {
            return matcher.group(0);
        }
        throw new InvalidParameterException("Format of \"title\" string is illegal");
    }

    private String extractSeason(String from) {
        Matcher matcher = SEASON_PATTERN.matcher(from);
        if (matcher.find()) {
            return matcher.group(0);
        }
        throw new InvalidParameterException("Format of \"title\" string is illegal");
    }

    private String extractEpisode(String from) {
        Matcher matcher = EPISODE_PATTERN.matcher(from);
        if (matcher.find()) {
            return matcher.group(0);
        }
        throw new InvalidParameterException("Format of \"title\" string is illegal");
    }

}
