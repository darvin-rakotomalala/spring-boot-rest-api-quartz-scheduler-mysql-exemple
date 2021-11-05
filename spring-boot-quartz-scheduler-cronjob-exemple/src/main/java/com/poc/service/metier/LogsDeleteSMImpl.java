package com.poc.service.metier;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.model.LogsDelete;
import com.poc.service.repository.LogsDeleteRepository;

@Service
public class LogsDeleteSMImpl implements LogsDeleteSM {

	private static final Logger LOG = LoggerFactory.getLogger(LogsDeleteSMImpl.class);
	
	@Autowired
	private LogsDeleteRepository messageRepository;

	@Override
	public void createMessageDelete() {
		
		try {
			
			LocalDate dateNow = LocalDate.now();
			LocalDate dateStart = dateNow.minusMonths(3);
			
			// save messages in table
			LogsDelete message = new LogsDelete();
			message.setContent("Suppression des rélevés télématiques");
			message.setDateStart(dateStart);

			message = messageRepository.save(message);
			
			LOG.info("===> Save messages in table successfully!");
			
		} catch (Exception e) {
			// TODO: handle exception
			LOG.info("Save messages in table error!");
			
			e.printStackTrace();
		}
	}

}
