package com.expense.core;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@org.springframework.context.annotation.Configuration
@EnableScheduling
@EnableAsync
public class Configuration implements  WebMvcConfigurer  {

	private static final Logger log = LogManager.getLogger(Configuration.class);
	
	public static Scheduler scheduler;
	
	
	@Bean
	@Primary
	public Scheduler scheduler()throws Exception {
		log.info("Scheduler Bean");
		Properties quartzProperties=new Properties();
		quartzProperties.put("org.quartz.scheduler.instanceId","AUTO");
		quartzProperties.put("org.quartz.scheduler.skipUpdateCheck","true");
		quartzProperties.put("org.quartz.scheduler.rmi.export", "false");
		quartzProperties.put("org.quartz.scheduler.rmi.proxy", "false");
		quartzProperties.put("org.quartz.scheduler.wrapJobExecutionInUserTransaction", "false");
		quartzProperties.put("org.quartz.scheduler.interruptJobsOnShutdownWithWait", "true");
		quartzProperties.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
		quartzProperties.put("org.quartz.threadPool.threadCount", "10");
		quartzProperties.put("org.quartz.threadPool.threadPriority", "5");
		quartzProperties.put("org.quartz.threadPool.threadsInheritContextClassLoaderOfInitializingThread", "true");
		quartzProperties.put("org.quartz.jobStore.misfireThreshold", "60000");
		quartzProperties.put("org.quartz.jobStore.class", "org.quartz.simpl.RAMJobStore");
		scheduler=new StdSchedulerFactory(quartzProperties).getScheduler();
	    return scheduler;
	} 
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pages/**").addResourceLocations("/resources/");
    }
}
