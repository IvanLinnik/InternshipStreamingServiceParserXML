package io.skai.okta.internshipstreamingserviceparserxml.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;

@Slf4j
public class CheckUpdateScheduler {
    public static void main(String[] args) {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();

            JobDetail job = newJob(CheckUpdateJob.class)
                    .withIdentity("check_update", "group1")
                    .build();

            scheduler.shutdown();
        } catch (SchedulerException e) {
            log.error("Error in scheluler: ", e);
        }
    }
}
