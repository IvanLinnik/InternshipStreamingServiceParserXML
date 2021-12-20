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
        String episodeTitle = lostFilmRssItem.getTitle();

        String tvSeriesTitle = extractFieldFrom(episodeTitle, TVS_TITLE_PATTERN);
        int seasonNumber = Integer.parseInt(extractFieldFrom(episodeTitle, SEASON_NUMBER_PATTERN));
        int episodeNumber = Integer.parseInt(extractFieldFrom(episodeTitle, EPISODE_NUMBER_PATTERN));

        return Episode.builder()
                      .season(seasonNumber)
                      .episodeNumber(episodeNumber)
                      .tvSeriesTitle(tvSeriesTitle)
                      .title(episodeTitle)
                      .description(lostFilmRssItem.getDescription())
                      .pubDate(lostFilmRssItem.getPubDate())
                      .link(lostFilmRssItem.getLink())
                      .build();
    }

    private String extractFieldFrom(String from, Pattern pattern) {
        Matcher matcher = pattern.matcher(from);
        if (matcher.find()) {
            return matcher.group(0);
        }
        throw new InvalidParameterException("Format of \"title\" string is illegal");
    }

}
