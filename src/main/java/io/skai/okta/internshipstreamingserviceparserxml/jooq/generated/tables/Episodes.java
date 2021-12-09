/*
 * This file is generated by jOOQ.
 */
package io.skai.okta.internshipstreamingserviceparserxml.jooq.generated.tables;


import io.skai.okta.internshipstreamingserviceparserxml.jooq.generated.DefaultSchema;
import io.skai.okta.internshipstreamingserviceparserxml.jooq.generated.Keys;
import io.skai.okta.internshipstreamingserviceparserxml.jooq.generated.tables.records.EpisodesRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;
import java.time.LocalDateTime;
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
public class Episodes extends TableImpl<EpisodesRecord> {

    private static final long serialVersionUID = -1317799962;

    /**
     * The reference instance of <code>episodes</code>
     */
    public static final Episodes EPISODES = new Episodes();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<EpisodesRecord> getRecordType() {
        return EpisodesRecord.class;
    }

    /**
     * The column <code>episodes.id</code>.
     */
    public final TableField<EpisodesRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>episodes.title</code>.
     */
    public final TableField<EpisodesRecord, String> TITLE = createField("title", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>episodes.description</code>.
     */
    public final TableField<EpisodesRecord, String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>episodes.pubDate</code>.
     */
    public final TableField<EpisodesRecord, LocalDateTime> PUBDATE = createField("pubDate", org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * The column <code>episodes.link</code>.
     */
    public final TableField<EpisodesRecord, String> LINK = createField("link", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * Create a <code>episodes</code> table reference
     */
    public Episodes() {
        this(DSL.name("episodes"), null);
    }

    /**
     * Create an aliased <code>episodes</code> table reference
     */
    public Episodes(String alias) {
        this(DSL.name(alias), EPISODES);
    }

    /**
     * Create an aliased <code>episodes</code> table reference
     */
    public Episodes(Name alias) {
        this(alias, EPISODES);
    }

    private Episodes(Name alias, Table<EpisodesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Episodes(Name alias, Table<EpisodesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Episodes(Table<O> child, ForeignKey<O, EpisodesRecord> key) {
        super(child, key, EPISODES);
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
    public Identity<EpisodesRecord, Long> getIdentity() {
        return Keys.IDENTITY_EPISODES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<EpisodesRecord> getPrimaryKey() {
        return Keys.KEY_EPISODES_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<EpisodesRecord>> getKeys() {
        return Arrays.<UniqueKey<EpisodesRecord>>asList(Keys.KEY_EPISODES_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Episodes as(String alias) {
        return new Episodes(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Episodes as(Name alias) {
        return new Episodes(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Episodes rename(String name) {
        return new Episodes(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Episodes rename(Name name) {
        return new Episodes(name, null);
    }
}
