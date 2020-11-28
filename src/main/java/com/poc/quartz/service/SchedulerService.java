package com.poc.quartz.service;

import com.poc.quartz.jobs.*;
import java.util.*;
import org.quartz.*;
import org.quartz.impl.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class SchedulerService {

  private final Scheduler sc;
  Map<String, Trigger> triggers;
  List<CustomJob> jobs;

  @Autowired
  public SchedulerService(Map<String, Trigger> triggers, List<CustomJob> jobs)
      throws SchedulerException {
    this.sc = new StdSchedulerFactory().getScheduler();
    this.triggers = triggers;
    this.jobs = jobs;
  }

  public void startScheduler() throws SchedulerException {
    sc.start();
  }

  public void configureTriggerWithJobs() {
    jobs.forEach(customJob ->
        {
          String triggerIdentity = customJob.getTriggerIdentity();
          final Trigger trigger = triggers.get(triggerIdentity);

          JobDetail job = JobBuilder
              .newJob(customJob.getClass())
              .build();

          try {
            sc.scheduleJob(job, trigger);
          } catch (SchedulerException e) {
            e.printStackTrace();
          }
        }
    );
  }
}
