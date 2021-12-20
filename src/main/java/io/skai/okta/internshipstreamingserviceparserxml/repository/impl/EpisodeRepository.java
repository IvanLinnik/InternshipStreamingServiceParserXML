package io.skai.okta.internshipstreamingserviceparserxml.repository.impl;

import io.skai.okta.internshipstreamingserviceparserxml.dto.Episode;
import io.skai.okta.internshipstreamingserviceparserxml.jooq.generated.tables.records.EpisodesRecord;
import io.skai.okta.internshipstreamingserviceparserxml.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.RecordMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static io.skai.okta.internshipstreamingserviceparserxml.jooq.generated.Tables.EPISODES;

@Repository
@RequiredArgsConstructor
@Slf4j
public class EpisodeRepository implements VideoRepository {
    private final DSLContext dslContext;

    @Override
    public void saveOrUpdate(Episode episode) {
        if (isPresent(episode)) {
            update(episode);
            return;
        }
        save(episode);
    }

    private boolean isPresent(Episode episode) {
        return getId(episode.getLink()).isPresent();
    }

    @Override
    public void save(Episode episode) {
        dslContext.insertInto(EPISODES,
                          EPISODES.SEASON,
                          EPISODES.EPISODE_NUMBER,
                          EPISODES.TV_SERIES_TITLE,
                          EPISODES.TITLE,
                          EPISODES.DESCRIPTION,
                          EPISODES.PUB_DATE,
                          EPISODES.LINK)
                  .values(episode.getSeason(),
                          episode.getEpisodeNumber(),
                          episode.getTvSeriesTitle(),
                          episode.getTitle(),
                          episode.getDescription(),
                          episode.getPubDate(),
                          episode.getLink())
                  .execute();
    }

    @Override
    public List<Episode> getAll() {
        return dslContext
                .selectFrom(EPISODES)
                .fetch(getEpisodeRecordMapper());
    }

    @Override
    public Episode get(String link) {
        return dslContext
                .selectFrom(EPISODES)
                .where(EPISODES.LINK.eq(link))
                .fetchSingle(getEpisodeRecordMapper());
    }

    @Override
    public void update(Episode episode) {
        dslContext.update(EPISODES)
                  .set(EPISODES.SEASON, episode.getSeason())
                  .set(EPISODES.EPISODE_NUMBER, episode.getEpisodeNumber())
                  .set(EPISODES.TV_SERIES_TITLE, episode.getTvSeriesTitle())
                  .set(EPISODES.TITLE, episode.getTitle())
                  .set(EPISODES.DESCRIPTION, episode.getDescription())
                  .set(EPISODES.PUB_DATE, episode.getPubDate())
                  .where(EPISODES.LINK.eq(episode.getLink()))
                  .execute();
    }

    @Override
    public Optional<Long> getId(String link) {
        return dslContext.selectFrom(EPISODES)
                         .where(EPISODES.LINK.eq(link))
                         .fetchOptional(EPISODES.ID);
    }

    private RecordMapper<EpisodesRecord, Episode> getEpisodeRecordMapper() {
        return record -> Episode.builder()
                                .id(record.getId())
                                .season(record.getSeason())
                                .episodeNumber(record.getEpisodeNumber())
                                .tvSeriesTitle(record.getTvSeriesTitle())
                                .title(record.getTitle())
                                .description(record.getDescription())
                                .pubDate(record.getPubDate())
                                .link(record.getLink())
                                .build();
    }

}
