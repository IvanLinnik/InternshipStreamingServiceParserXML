package io.skai.okta.internshipstreamingserviceparserxml.quartz;

import io.skai.okta.internshipstreamingserviceparserxml.services.VideoService;
import lombok.RequiredArgsConstructor;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CheckUpdateJob implements Job {
    private final VideoService service;

    @Override
    public void execute(JobExecutionContext context) {
        service.saveNewVideos();
    }
}
