package io.skai.okta.internshipstreamingserviceparserxml.scheduler;

import io.skai.okta.internshipstreamingserviceparserxml.item.ItemService;
import lombok.RequiredArgsConstructor;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CheckUpdateJob implements Job {
    private final ItemService service;

    @Override
    public void execute(JobExecutionContext context) {
        service.getItem();
    }
}
