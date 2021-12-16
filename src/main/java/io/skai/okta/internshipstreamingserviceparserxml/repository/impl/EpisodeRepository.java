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
        } else {
            save(episode);
        }
    }

    private boolean isPresent(Episode episode) {
        return getId(episode.getLink()).isPresent();
    }

    @Override
    public void save(Episode episode) {
        dslContext.insertInto(EPISODES,
                          EPISODES.SEASON,
                          EPISODES.EPISODENUMBER,
                          EPISODES.TVSERIESTITLE,
                          EPISODES.TITLE,
                          EPISODES.DESCRIPTION,
                          EPISODES.PUBDATE,
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
                  .set(EPISODES.EPISODENUMBER, episode.getEpisodeNumber())
                  .set(EPISODES.TVSERIESTITLE, episode.getTvSeriesTitle())
                  .set(EPISODES.TITLE, episode.getTitle())
                  .set(EPISODES.DESCRIPTION, episode.getDescription())
                  .set(EPISODES.PUBDATE, episode.getPubDate())
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
                                .title(record.getTitle())
                                .description(record.getDescription())
                                .pubDate(record.getPubdate())
                                .link(record.getLink())
                                .build();
    }

//    @Override
//    public void delete(long id) {
//        dslContext.deleteFrom(EPISODES)
//                  .where(EPISODES.ID.eq(id))
//                  .execute();
//    }

//    @Override
//    public void delete(String link) {
//        dslContext.deleteFrom(EPISODES)
//                  .where(EPISODES.LINK.eq(link))
//                  .execute();
//    }

//    @Override
//    public Episode get(long id) {
//        return dslContext
//                .selectFrom(EPISODES)
//                .where(EPISODES.ID.eq(id))
//                .fetchSingle(getEpisodeRecordMapper());
//    }

}
