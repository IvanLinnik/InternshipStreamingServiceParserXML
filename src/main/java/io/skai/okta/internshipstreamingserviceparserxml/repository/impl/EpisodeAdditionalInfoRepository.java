package io.skai.okta.internshipstreamingserviceparserxml.repository.impl;

import io.skai.okta.internshipstreamingserviceparserxml.dto.EpisodeAdditionalInfo;
import io.skai.okta.internshipstreamingserviceparserxml.jooq.generated.tables.records.EpisodesAdditionalDataRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.RecordMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

import static io.skai.okta.internshipstreamingserviceparserxml.jooq.generated.Tables.EPISODES_ADDITIONAL_DATA;

@Repository
@RequiredArgsConstructor
public class EpisodeAdditionalInfoRepository {
    private final DSLContext dslContext;

    public void saveOrUpdate(EpisodeAdditionalInfo episodeAdditionalInfo) {
        if (isPresent(episodeAdditionalInfo)) {
            update(episodeAdditionalInfo);
            return;
        }
        save(episodeAdditionalInfo);
    }

    private boolean isPresent(EpisodeAdditionalInfo episodeAdditionalInfo) {
        return dslContext.selectFrom(EPISODES_ADDITIONAL_DATA)
                         .where(EPISODES_ADDITIONAL_DATA.PARENT_ID.eq(episodeAdditionalInfo.getParentId()))
                         .fetchOptional(EPISODES_ADDITIONAL_DATA.ID)
                         .isPresent();
    }

    public void save(EpisodeAdditionalInfo episodeAdditionalInfo) {
        dslContext.insertInto(EPISODES_ADDITIONAL_DATA,
                          EPISODES_ADDITIONAL_DATA.PARENT_ID,
                          EPISODES_ADDITIONAL_DATA.IMDB_ID,
                          EPISODES_ADDITIONAL_DATA.IMDB_RATING,
                          EPISODES_ADDITIONAL_DATA.IMDB_VOTES,
                          EPISODES_ADDITIONAL_DATA.RUNTIME,
                          EPISODES_ADDITIONAL_DATA.SERIES_ID)
                  .values(episodeAdditionalInfo.getParentId(),
                          episodeAdditionalInfo.getImdbID(),
                          episodeAdditionalInfo.getImdbRating(),
                          episodeAdditionalInfo.getImdbVotes(),
                          episodeAdditionalInfo.getRuntime(),
                          episodeAdditionalInfo.getSeriesID())
                  .execute();
    }

    public List<EpisodeAdditionalInfo> getAll() {
        return dslContext
                .selectFrom(EPISODES_ADDITIONAL_DATA)
                .fetch(getEpisodeAdditionalInfoRecordMapper());
    }

    public EpisodeAdditionalInfo findByParentId(long parentId) {
        return dslContext
                .selectFrom(EPISODES_ADDITIONAL_DATA)
                .where(EPISODES_ADDITIONAL_DATA.PARENT_ID.eq(parentId))
                .fetchSingle(getEpisodeAdditionalInfoRecordMapper());
    }

    public void update(EpisodeAdditionalInfo episodeAdditionalInfo) {
        dslContext.update(EPISODES_ADDITIONAL_DATA)
                  .set(EPISODES_ADDITIONAL_DATA.IMDB_ID, episodeAdditionalInfo.getImdbID())
                  .set(EPISODES_ADDITIONAL_DATA.IMDB_RATING, episodeAdditionalInfo.getImdbRating())
                  .set(EPISODES_ADDITIONAL_DATA.IMDB_VOTES, episodeAdditionalInfo.getImdbVotes())
                  .set(EPISODES_ADDITIONAL_DATA.RUNTIME, episodeAdditionalInfo.getRuntime())
                  .set(EPISODES_ADDITIONAL_DATA.SERIES_ID, episodeAdditionalInfo.getSeriesID())
                  .where(EPISODES_ADDITIONAL_DATA.PARENT_ID.eq(episodeAdditionalInfo.getParentId()))
                  .execute();
    }

    public void delete(long parentId) {
        dslContext.deleteFrom(EPISODES_ADDITIONAL_DATA)
                  .where(EPISODES_ADDITIONAL_DATA.PARENT_ID.eq(parentId))
                  .execute();
    }

    private RecordMapper<EpisodesAdditionalDataRecord, EpisodeAdditionalInfo> getEpisodeAdditionalInfoRecordMapper() {
        return record -> EpisodeAdditionalInfo.builder()
                                              .id(record.getId())
                                              .parentId(record.getParentId())
                                              .imdbID(record.getImdbId())
                                              .imdbRating(record.getImdbRating())
                                              .imdbVotes(record.getImdbVotes())
                                              .runtime(record.getRuntime())
                                              .seriesID(record.getSeriesId())
                                              .build();
    }

}
