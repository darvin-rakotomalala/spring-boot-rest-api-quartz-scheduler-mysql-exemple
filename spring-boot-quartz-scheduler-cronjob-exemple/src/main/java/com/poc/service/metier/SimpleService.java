package com.poc.service.metier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SimpleService {

	private static final Logger LOG = LoggerFactory.getLogger(SimpleService.class);
	
	public void processData() {
		LOG.info("******* Delete data IoT more than 3 months successfully! *******");
	}
}
