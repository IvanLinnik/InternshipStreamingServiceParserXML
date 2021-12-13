package io.skai.okta.internshipstreamingserviceparserxml.quartz;

import io.skai.okta.internshipstreamingserviceparserxml.services.LostFilmService;
import lombok.RequiredArgsConstructor;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CheckUpdateJob implements Job {
    private final LostFilmService service;

    @Override
    public void execute(JobExecutionContext context) {
        service.createNewEpisodes();
    }
}
