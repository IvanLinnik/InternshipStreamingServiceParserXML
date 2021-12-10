package io.skai.okta.internshipstreamingserviceparserxml.quartz;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

@Configuration
public class SpringQuartzConfig {
    @Bean
    public JobDetail jobDetail() {
        return JobBuilder.newJob().ofType(CheckUpdateJob.class)
                         .storeDurably()
                         .withIdentity(new JobKey("HourlyWork", Scheduler.DEFAULT_GROUP))
                         .withDescription("Invoke Lostfilm RSS update service...")
                         .build();
    }

    @Bean
    public Trigger trigger(JobDetail job) {
        return TriggerBuilder.newTrigger().forJob(job)
                             .withIdentity(new TriggerKey("HourlyWorkTrigger", Scheduler.DEFAULT_GROUP))
                             .withDescription("Invoke check update every 1 hour")
                             .withSchedule(simpleSchedule().repeatForever().withIntervalInHours(1))
                             .build();
    }

}
