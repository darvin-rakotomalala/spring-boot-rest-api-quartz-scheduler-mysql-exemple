package com.poc.config;

import java.io.IOException;
import java.text.ParseException;

import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.spi.JobFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.poc.job.SimpleJobDelete;

@Configuration
@EnableAutoConfiguration
public class SchedulerConfig {

	private static final Logger LOG = LoggerFactory.getLogger(SchedulerConfig.class);

	@Bean
	public JobFactory jobFactory(ApplicationContext applicationContext) {
		AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
		jobFactory.setApplicationContext(applicationContext);
		return jobFactory;
	}

	@Bean
	public SchedulerFactoryBean schedulerFactoryBean(JobFactory jobFactory, Trigger simpleJobTrigger)
			throws IOException {
		SchedulerFactoryBean factory = new SchedulerFactoryBean();
		factory.setJobFactory(jobFactory);
		// factory.setQuartzProperties(quartzProperties());
		factory.setTriggers(simpleJobTrigger);
		LOG.info("starting jobs....");
		return factory;
	}

	/*
	@Bean
	public SimpleTriggerFactoryBean simpleJobTrigger(@Qualifier("simpleJobDetail") JobDetail jobDetail,
			@Value("${simplejob.frequency}") long frequency) {
		LOG.info("simpleJobTrigger");

		SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
		factoryBean.setJobDetail(jobDetail);
		factoryBean.setStartDelay(0L);
		factoryBean.setRepeatInterval(frequency);
		factoryBean.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
		return factoryBean;
	}
	*/
	
	@Bean
	public Trigger simpleJobTrigger(@Qualifier("simpleJobDetail") JobDetail jobDetail) {

	    CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
	    factoryBean.setJobDetail(jobDetail);
	    factoryBean.setStartDelay(0L);
	    factoryBean.setName("test-trigger");
	    factoryBean.setCronExpression("0 0/15 * * * ?");
	    factoryBean.setMisfireInstruction(SimpleTrigger.MISFIRE_INSTRUCTION_FIRE_NOW);

	    try {
	        factoryBean.afterPropertiesSet();
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    return factoryBean.getObject();
	}

	/*
	@Bean
	public Properties quartzProperties() throws IOException {
		PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
		propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
		propertiesFactoryBean.afterPropertiesSet();
		return propertiesFactoryBean.getObject();
	}
	*/

	@Bean
	public JobDetailFactoryBean simpleJobDetail() {
		JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
		factoryBean.setJobClass(SimpleJobDelete.class);
		factoryBean.setDurability(true);
		return factoryBean;
	}

}
