package com.poc.quartz.config;

import java.util.*;
import org.quartz.*;
import org.springframework.context.annotation.*;

@Configuration
public class TriggersConfiguration {

  @Bean
  public Map<String, Trigger> triggers() {
    Map<String, Trigger> triggers = new HashMap<>();

    String triggerOneIdentity = "simpleTrigger";
    Trigger t1 = TriggerBuilder
        .newTrigger()
        .withIdentity(triggerOneIdentity)
        .startNow()
        .build();

    triggers.put(triggerOneIdentity, t1);

    String triggerTwoIdentity = "simpleTrigger2";
    Trigger t2 = TriggerBuilder
        .newTrigger()
        .withIdentity(triggerTwoIdentity)
        .startNow()
        .build();

    triggers.put(triggerTwoIdentity, t2);

    String triggerTokenRefreshIdentity = "token-refresh";
    Trigger tokenRefreshTrigger = TriggerBuilder
        .newTrigger()
        .withIdentity(triggerTokenRefreshIdentity)
        .startNow()
        .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(5))
        .build();

    triggers.put(triggerTokenRefreshIdentity, tokenRefreshTrigger);
    return triggers;
  }
}
