package com.poc.service.metier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.service.businessdelegate.DeleteDataIotByDatetime;

@Service
public class DeleteDataIotSMImpl implements DeleteDataIotSM {

	private static final Logger LOG = LoggerFactory.getLogger(DeleteDataIotSMImpl.class);
	
	@Autowired
	DeleteDataIotByDatetime deleteDataIotByDatetime;
	
	@Override
	public void deleteDataiotByDatetime() {
		try {
			deleteDataIotByDatetime.deleteDataiotByDatetime();
			LOG.info("===> Delete data Iot successfully!");
		} catch (Exception e) {
			// TODO: handle exception
			LOG.info("Delete data Iot error!");
		}
		
	}

}
