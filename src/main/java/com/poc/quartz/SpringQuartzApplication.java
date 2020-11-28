package com.poc.quartz;

import com.poc.quartz.service.*;
import org.quartz.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.*;

@SpringBootApplication
public class SpringQuartzApplication {

  public static void main(String[] args) throws SchedulerException {
    ConfigurableApplicationContext context = SpringApplication
        .run(SpringQuartzApplication.class, args);
/*    JobDetail job = JobBuilder
        .newJob(QuartzJob.class)
        .build();

    //create trigger
    Trigger t1 = TriggerBuilder
        .newTrigger()
        .withIdentity("simpleTrigger")
        .startNow()
        .build();

    Scheduler sc = new StdSchedulerFactory().getScheduler();
    sc.start();
    sc.scheduleJob(job, t1);*/

    final SchedulerService scheduler = context.getBean(SchedulerService.class);
    scheduler.configureTriggerWithJobs();
    scheduler.startScheduler();
  }
}
