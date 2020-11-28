package com.poc.quartz.jobs;


import org.quartz.*;
import org.springframework.stereotype.*;

@Service
public class QuartzJob implements CustomJob {

  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    System.out.println("job triggered");
  }

  @Override
  public String getTriggerIdentity() {
    return "simpleTrigger";
  }
}
