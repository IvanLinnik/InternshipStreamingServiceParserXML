package io.skai.okta.internshipstreamingserviceparserxml.repository;

import io.skai.okta.internshipstreamingserviceparserxml.dto.Episode;
import io.skai.okta.internshipstreamingserviceparserxml.jooq.generated.tables.records.EpisodesRecord;
import io.skai.okta.internshipstreamingserviceparserxml.services.EpisodesConverter;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.RecordMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static io.skai.okta.internshipstreamingserviceparserxml.jooq.generated.tables.Episodes.EPISODES;

@Repository
@RequiredArgsConstructor
public class EpisodeRepositoryImpl implements EpisodeRepository {
    private final DSLContext dslContext;
    private final EpisodesConverter episodesConverter;

    @Override
    public void create(Episode episode) {
        if (getId(episode.getLink()).isEmpty()) {
            dslContext.insertInto(EPISODES,
                              EPISODES.TITLE,
                              EPISODES.DESCRIPTION,
                              EPISODES.PUBDATE,
                              EPISODES.LINK)
                      .values(episodesConverter.getTitle(episode),
                              episodesConverter.getDescription(episode),
                              episodesConverter.getPubDate(episode),
                              episodesConverter.getLink(episode))
                      .execute();
        } else {
            update(episode);
        }
    }

    @Override
    public List<Episode> getItems() {
        return dslContext
                .selectFrom(EPISODES)
                .fetch(getEpisodeRecordMapper());
    }

    @Override
    public Episode getItem(long id) {
        return dslContext
                .selectFrom(EPISODES)
                .where(EPISODES.ID.eq(id))
                .fetchSingle(getEpisodeRecordMapper());
    }

    @Override
    public Episode getItem(String link) {
        return dslContext
                .selectFrom(EPISODES)
                .where(EPISODES.LINK.eq(link))
                .fetchSingle(getEpisodeRecordMapper());
    }

    @Override
    public void update(Episode episode) {
        dslContext.update(EPISODES)
                  .set(EPISODES.TITLE, episodesConverter.getTitle(episode))
                  .set(EPISODES.DESCRIPTION, episodesConverter.getDescription(episode))
                  .set(EPISODES.PUBDATE, episodesConverter.getPubDate(episode))
                  .where(EPISODES.LINK.eq(episodesConverter.getLink(episode)))
                  .execute();
    }

    @Override
    public void delete(long id) {
        dslContext.deleteFrom(EPISODES)
                  .where(EPISODES.ID.eq(id))
                  .execute();
    }

    @Override
    public void delete(String link) {
        dslContext.deleteFrom(EPISODES)
                  .where(EPISODES.LINK.eq(link))
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

}
