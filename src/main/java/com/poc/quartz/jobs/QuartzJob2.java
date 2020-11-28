package com.poc.quartz.jobs;

import org.quartz.*;
import org.springframework.stereotype.*;

@Service
public class QuartzJob2 implements CustomJob {

  @Override
  public String getTriggerIdentity() {
    return "simpleTrigger2";
  }

  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    System.out.println("job2 triggered");
  }
}
