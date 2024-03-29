/*
 * This file is generated by jOOQ.
 */
package io.skai.okta.internshipstreamingserviceparserxml.jooq.generated.tables.records;


import io.skai.okta.internshipstreamingserviceparserxml.jooq.generated.tables.EpisodesAdditionalData;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class EpisodesAdditionalDataRecord extends UpdatableRecordImpl<EpisodesAdditionalDataRecord> implements Record7<Long, String, String, String, String, String, Long> {

    private static final long serialVersionUID = 528687704;

    /**
     * Setter for <code>episodes_additional_data.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>episodes_additional_data.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>episodes_additional_data.imdb_id</code>.
     */
    public void setImdbId(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>episodes_additional_data.imdb_id</code>.
     */
    public String getImdbId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>episodes_additional_data.series_id</code>.
     */
    public void setSeriesId(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>episodes_additional_data.series_id</code>.
     */
    public String getSeriesId() {
        return (String) get(2);
    }

    /**
     * Setter for <code>episodes_additional_data.imdb_rating</code>.
     */
    public void setImdbRating(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>episodes_additional_data.imdb_rating</code>.
     */
    public String getImdbRating() {
        return (String) get(3);
    }

    /**
     * Setter for <code>episodes_additional_data.imdb_votes</code>.
     */
    public void setImdbVotes(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>episodes_additional_data.imdb_votes</code>.
     */
    public String getImdbVotes() {
        return (String) get(4);
    }

    /**
     * Setter for <code>episodes_additional_data.runtime</code>.
     */
    public void setRuntime(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>episodes_additional_data.runtime</code>.
     */
    public String getRuntime() {
        return (String) get(5);
    }

    /**
     * Setter for <code>episodes_additional_data.parent_id</code>.
     */
    public void setParentId(Long value) {
        set(6, value);
    }

    /**
     * Getter for <code>episodes_additional_data.parent_id</code>.
     */
    public Long getParentId() {
        return (Long) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Long, String, String, String, String, String, Long> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Long, String, String, String, String, String, Long> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return EpisodesAdditionalData.EPISODES_ADDITIONAL_DATA.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return EpisodesAdditionalData.EPISODES_ADDITIONAL_DATA.IMDB_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return EpisodesAdditionalData.EPISODES_ADDITIONAL_DATA.SERIES_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return EpisodesAdditionalData.EPISODES_ADDITIONAL_DATA.IMDB_RATING;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return EpisodesAdditionalData.EPISODES_ADDITIONAL_DATA.IMDB_VOTES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return EpisodesAdditionalData.EPISODES_ADDITIONAL_DATA.RUNTIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field7() {
        return EpisodesAdditionalData.EPISODES_ADDITIONAL_DATA.PARENT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getImdbId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getSeriesId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getImdbRating();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getImdbVotes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getRuntime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component7() {
        return getParentId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getImdbId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getSeriesId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getImdbRating();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getImdbVotes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getRuntime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value7() {
        return getParentId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EpisodesAdditionalDataRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EpisodesAdditionalDataRecord value2(String value) {
        setImdbId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EpisodesAdditionalDataRecord value3(String value) {
        setSeriesId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EpisodesAdditionalDataRecord value4(String value) {
        setImdbRating(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EpisodesAdditionalDataRecord value5(String value) {
        setImdbVotes(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EpisodesAdditionalDataRecord value6(String value) {
        setRuntime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EpisodesAdditionalDataRecord value7(Long value) {
        setParentId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EpisodesAdditionalDataRecord values(Long value1, String value2, String value3, String value4, String value5, String value6, Long value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached EpisodesAdditionalDataRecord
     */
    public EpisodesAdditionalDataRecord() {
        super(EpisodesAdditionalData.EPISODES_ADDITIONAL_DATA);
    }

    /**
     * Create a detached, initialised EpisodesAdditionalDataRecord
     */
    public EpisodesAdditionalDataRecord(Long id, String imdbId, String seriesId, String imdbRating, String imdbVotes, String runtime, Long parentId) {
        super(EpisodesAdditionalData.EPISODES_ADDITIONAL_DATA);

        set(0, id);
        set(1, imdbId);
        set(2, seriesId);
        set(3, imdbRating);
        set(4, imdbVotes);
        set(5, runtime);
        set(6, parentId);
    }
}
