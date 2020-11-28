package com.poc.quartz.config;

import org.springframework.beans.*;
import org.springframework.context.*;
import org.springframework.stereotype.*;

@Component
public class SpringContext implements ApplicationContextAware {

  private static ApplicationContext context;

  public static <T extends Object> T getBean(Class<T> beanClass) {
    return context.getBean(beanClass);
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    context = applicationContext;
  }
}
