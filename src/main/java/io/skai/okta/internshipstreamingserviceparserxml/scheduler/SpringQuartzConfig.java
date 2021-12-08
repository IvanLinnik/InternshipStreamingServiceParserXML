package io.skai.okta.internshipstreamingserviceparserxml.scheduler;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

@Configuration
public class SpringQuartzConfig {
    @Bean
    public JobDetail jobDetail() {
        return JobBuilder.newJob().ofType(CheckUpdateJob.class)
                         .storeDurably()
                         .withIdentity("Updater")
                         .withDescription("Invoke Lostfilm RSS update service...")
                         .build();
    }

    @Bean
    public Trigger trigger(JobDetail job) {
        return TriggerBuilder.newTrigger().forJob(job)
                             .withIdentity("Time_Trigger")
                             .withDescription("Invoke check update every 1 hour")
                             .withSchedule(simpleSchedule().repeatForever().withIntervalInHours(1))
                             .build();
    }

}
