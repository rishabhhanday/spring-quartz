package com.poc.quartz.jobs;

import org.quartz.*;

public interface CustomJob extends Job {

  String getTriggerIdentity();
}
