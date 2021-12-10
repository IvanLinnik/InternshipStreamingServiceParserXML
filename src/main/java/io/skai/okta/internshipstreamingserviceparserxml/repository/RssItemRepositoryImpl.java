package io.skai.okta.internshipstreamingserviceparserxml.repository;

import io.skai.okta.internshipstreamingserviceparserxml.dto.RssItem;
import io.skai.okta.internshipstreamingserviceparserxml.jooq.generated.tables.records.EpisodesRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.RecordMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static io.skai.okta.internshipstreamingserviceparserxml.jooq.generated.tables.Episodes.EPISODES;

@Repository
@RequiredArgsConstructor
public class RssItemRepositoryImpl implements RssItemRepository {
    private final DSLContext dslContext;

    @Override
    public void create(RssItem rssItem) {
        if (getId(rssItem.getLink()).isEmpty()) {
            dslContext.insertInto(EPISODES,
                              EPISODES.TITLE,
                              EPISODES.DESCRIPTION,
                              EPISODES.PUBDATE,
                              EPISODES.LINK)
                      .values(rssItem.getTitle(),
                              rssItem.getDescription(),
                              rssItem.getPubDate(),
                              rssItem.getLink())
                      .execute();
        } else {
            update(rssItem);
        }
    }

    @Override
    public List<RssItem> getItems() {
        return dslContext
                .selectFrom(EPISODES)
                .fetch(getEpisodeRecordMapper());
    }

    @Override
    public RssItem getItem(long id) {
        return dslContext
                .selectFrom(EPISODES)
                .where(EPISODES.ID.eq(id))
                .fetchSingle(getEpisodeRecordMapper());
    }

    @Override
    public RssItem getItem(String link) {
        return dslContext
                .selectFrom(EPISODES)
                .where(EPISODES.LINK.eq(link))
                .fetchSingle(getEpisodeRecordMapper());
    }

    @Override
    public void update(RssItem rssItem) {
        dslContext.update(EPISODES)
                  .set(EPISODES.TITLE, rssItem.getTitle())
                  .set(EPISODES.DESCRIPTION, rssItem.getDescription())
                  .set(EPISODES.PUBDATE, rssItem.getPubDate())
                  .where(EPISODES.LINK.eq(rssItem.getLink()))
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

    private RecordMapper<EpisodesRecord, RssItem> getEpisodeRecordMapper() {
        return record -> RssItem
                .builder()
                .title(record.getTitle())
                .description(record.getDescription())
                .pubDate(record.getPubdate())
                .link(record.getLink())
                .build();
    }

}
