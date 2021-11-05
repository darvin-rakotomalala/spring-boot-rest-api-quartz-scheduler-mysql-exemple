package com.poc.service.businessdelegate;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;

@FeignClient(name = "dataiotFeignClient", url = "${pf.dataiot.mcs.api.deleteData.url}")
public interface DeleteDataIotByDatetime {
	
	@DeleteMapping
	public void deleteDataiotByDatetime();
	
}
