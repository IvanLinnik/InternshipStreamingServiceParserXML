package io.skai.okta.internshipstreamingserviceparserxml.scheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class CheckUpdateJob implements Job {
    @Override
    public void execute(JobExecutionContext context) {
        System.out.println("hello");
    }
}
