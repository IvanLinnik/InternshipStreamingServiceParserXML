/*
 * This file is generated by jOOQ.
 */
package io.skai.okta.internshipstreamingserviceparserxml.jooq.generated;


import io.skai.okta.internshipstreamingserviceparserxml.jooq.generated.tables.Episodes;
import io.skai.okta.internshipstreamingserviceparserxml.jooq.generated.tables.EpisodesAdditionalData;
import io.skai.okta.internshipstreamingserviceparserxml.jooq.generated.tables.records.EpisodesAdditionalDataRecord;
import io.skai.okta.internshipstreamingserviceparserxml.jooq.generated.tables.records.EpisodesRecord;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;

import javax.annotation.Generated;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code></code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<EpisodesRecord, Long> IDENTITY_EPISODES = Identities0.IDENTITY_EPISODES;
    public static final Identity<EpisodesAdditionalDataRecord, Long> IDENTITY_EPISODES_ADDITIONAL_DATA = Identities0.IDENTITY_EPISODES_ADDITIONAL_DATA;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<EpisodesRecord> KEY_EPISODES_PRIMARY = UniqueKeys0.KEY_EPISODES_PRIMARY;
    public static final UniqueKey<EpisodesAdditionalDataRecord> KEY_EPISODES_ADDITIONAL_DATA_PRIMARY = UniqueKeys0.KEY_EPISODES_ADDITIONAL_DATA_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<EpisodesRecord, Long> IDENTITY_EPISODES = Internal.createIdentity(Episodes.EPISODES, Episodes.EPISODES.ID);
        public static Identity<EpisodesAdditionalDataRecord, Long> IDENTITY_EPISODES_ADDITIONAL_DATA = Internal.createIdentity(EpisodesAdditionalData.EPISODES_ADDITIONAL_DATA, EpisodesAdditionalData.EPISODES_ADDITIONAL_DATA.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<EpisodesRecord> KEY_EPISODES_PRIMARY = Internal.createUniqueKey(Episodes.EPISODES, "KEY_episodes_PRIMARY", Episodes.EPISODES.ID);
        public static final UniqueKey<EpisodesAdditionalDataRecord> KEY_EPISODES_ADDITIONAL_DATA_PRIMARY = Internal.createUniqueKey(EpisodesAdditionalData.EPISODES_ADDITIONAL_DATA, "KEY_episodes_additional_data_PRIMARY", EpisodesAdditionalData.EPISODES_ADDITIONAL_DATA.ID);
    }
}
