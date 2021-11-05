package com.poc.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.poc.service.metier.DeleteDataIotSM;
import com.poc.service.metier.LogsDeleteSM;
import com.poc.service.metier.SimpleService;

public class SimpleJobDelete implements Job {

	@Autowired
	private SimpleService service;
	
	@Autowired
	private LogsDeleteSM messageSM;
	
	@Autowired
	private DeleteDataIotSM deleteDataIotSM;

	@Override
	public void execute(JobExecutionContext jobExecutionContext) {
		service.processData();
		messageSM.createMessageDelete();
		deleteDataIotSM.deleteDataiotByDatetime();
	}

}
