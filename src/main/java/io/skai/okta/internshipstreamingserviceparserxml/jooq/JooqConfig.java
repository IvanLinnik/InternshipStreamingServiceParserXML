package io.skai.okta.internshipstreamingserviceparserxml.jooq;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class JooqConfig {
    private final DataSource dataSource;

}
