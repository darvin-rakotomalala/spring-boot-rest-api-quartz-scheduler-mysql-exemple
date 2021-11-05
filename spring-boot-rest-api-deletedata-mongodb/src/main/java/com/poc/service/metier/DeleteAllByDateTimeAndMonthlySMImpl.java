package com.poc.service.metier;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.poc.service.repository.GpsRepository;

@Service
public class DeleteAllByDateTimeAndMonthlySMImpl implements DeleteAllByDateTimeAndMonthlySM {

	@Autowired
	GpsRepository gpsRepository;

	@Override
	public void deleteAllByDateTimeAndMonthly(String startDate, String month, int paquet) {

		int months = Integer.parseInt(month);
		LocalDateTime dateStart;
		if (StringUtils.isEmpty(startDate)) {
			dateStart = LocalDateTime.now();
		} else {
			dateStart = LocalDateTime.parse(startDate);
		}

		LocalDateTime endDate = dateStart.minusMonths(months);

		// Gps
		Executors.newCachedThreadPool().execute(() -> {
			Pageable pageGps = PageRequest.of(0, paquet);
			gpsRepository
					.deleteAll(gpsRepository.findAllByDateTimeAndMonthly(endDate.toString(), pageGps).getContent());
			int totalPageGps = gpsRepository.findAllByDateTimeAndMonthly(endDate.toString(), pageGps).getTotalPages();
			while (totalPageGps > 0) {
				pageGps = PageRequest.of(0, paquet);
				gpsRepository
						.deleteAll(gpsRepository.findAllByDateTimeAndMonthly(endDate.toString(), pageGps).getContent());
				totalPageGps -= paquet;
			}
		});
	}

}
