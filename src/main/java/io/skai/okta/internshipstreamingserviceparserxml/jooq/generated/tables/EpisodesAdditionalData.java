/*
 * This file is generated by jOOQ.
 */
package io.skai.okta.internshipstreamingserviceparserxml.jooq.generated.tables;


import io.skai.okta.internshipstreamingserviceparserxml.jooq.generated.DefaultSchema;
import io.skai.okta.internshipstreamingserviceparserxml.jooq.generated.Keys;
import io.skai.okta.internshipstreamingserviceparserxml.jooq.generated.tables.records.EpisodesAdditionalDataRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;
import java.util.Arrays;
import java.util.List;


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
public class EpisodesAdditionalData extends TableImpl<EpisodesAdditionalDataRecord> {

    private static final long serialVersionUID = 713980928;

    /**
     * The reference instance of <code>episodes_additional_data</code>
     */
    public static final EpisodesAdditionalData EPISODES_ADDITIONAL_DATA = new EpisodesAdditionalData();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<EpisodesAdditionalDataRecord> getRecordType() {
        return EpisodesAdditionalDataRecord.class;
    }

    /**
     * The column <code>episodes_additional_data.id</code>.
     */
    public final TableField<EpisodesAdditionalDataRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>episodes_additional_data.imdb_id</code>.
     */
    public final TableField<EpisodesAdditionalDataRecord, String> IMDB_ID = createField("imdb_id", org.jooq.impl.SQLDataType.VARCHAR(64), this, "");

    /**
     * The column <code>episodes_additional_data.series_id</code>.
     */
    public final TableField<EpisodesAdditionalDataRecord, String> SERIES_ID = createField("series_id", org.jooq.impl.SQLDataType.VARCHAR(64), this, "");

    /**
     * The column <code>episodes_additional_data.imdb_rating</code>.
     */
    public final TableField<EpisodesAdditionalDataRecord, String> IMDB_RATING = createField("imdb_rating", org.jooq.impl.SQLDataType.VARCHAR(64), this, "");

    /**
     * The column <code>episodes_additional_data.imdb_votes</code>.
     */
    public final TableField<EpisodesAdditionalDataRecord, String> IMDB_VOTES = createField("imdb_votes", org.jooq.impl.SQLDataType.VARCHAR(64), this, "");

    /**
     * The column <code>episodes_additional_data.runtime</code>.
     */
    public final TableField<EpisodesAdditionalDataRecord, String> RUNTIME = createField("runtime", org.jooq.impl.SQLDataType.VARCHAR(64), this, "");

    /**
     * The column <code>episodes_additional_data.parent_id</code>.
     */
    public final TableField<EpisodesAdditionalDataRecord, Long> PARENT_ID = createField("parent_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * Create a <code>episodes_additional_data</code> table reference
     */
    public EpisodesAdditionalData() {
        this(DSL.name("episodes_additional_data"), null);
    }

    /**
     * Create an aliased <code>episodes_additional_data</code> table reference
     */
    public EpisodesAdditionalData(String alias) {
        this(DSL.name(alias), EPISODES_ADDITIONAL_DATA);
    }

    /**
     * Create an aliased <code>episodes_additional_data</code> table reference
     */
    public EpisodesAdditionalData(Name alias) {
        this(alias, EPISODES_ADDITIONAL_DATA);
    }

    private EpisodesAdditionalData(Name alias, Table<EpisodesAdditionalDataRecord> aliased) {
        this(alias, aliased, null);
    }

    private EpisodesAdditionalData(Name alias, Table<EpisodesAdditionalDataRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> EpisodesAdditionalData(Table<O> child, ForeignKey<O, EpisodesAdditionalDataRecord> key) {
        super(child, key, EPISODES_ADDITIONAL_DATA);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<EpisodesAdditionalDataRecord, Long> getIdentity() {
        return Keys.IDENTITY_EPISODES_ADDITIONAL_DATA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<EpisodesAdditionalDataRecord> getPrimaryKey() {
        return Keys.KEY_EPISODES_ADDITIONAL_DATA_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<EpisodesAdditionalDataRecord>> getKeys() {
        return Arrays.<UniqueKey<EpisodesAdditionalDataRecord>>asList(Keys.KEY_EPISODES_ADDITIONAL_DATA_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EpisodesAdditionalData as(String alias) {
        return new EpisodesAdditionalData(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EpisodesAdditionalData as(Name alias) {
        return new EpisodesAdditionalData(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public EpisodesAdditionalData rename(String name) {
        return new EpisodesAdditionalData(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public EpisodesAdditionalData rename(Name name) {
        return new EpisodesAdditionalData(name, null);
    }
}