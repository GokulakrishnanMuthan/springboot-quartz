package com.example.quartzdemo;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigureJob {
	
	@Bean
    public JobDetail jobADetails() {
        return JobBuilder.newJob(SimpleJob.class).withIdentity("sampleJobA")
                .storeDurably().build();
    }

    @Bean
    public Trigger jobATrigger(JobDetail jobADetails) {

        return TriggerBuilder.newTrigger().forJob(jobADetails)

                .withIdentity("sampleTriggerA")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * ? * * *"))
                .build();
    }
    
    
}
