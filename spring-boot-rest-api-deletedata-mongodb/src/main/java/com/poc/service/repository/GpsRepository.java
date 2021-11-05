package com.poc.service.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.poc.donnee.domain.Gps;

@Repository
public interface GpsRepository extends MongoRepository<Gps, String> {

	@Query("{'dateTime' : { $lte: ?0}}")
	Page<Gps> findAllByDateTimeAndMonthly(String endDate, Pageable pageable);

	@Query(value = "{'dateTime' : { $lte: ?0}}", count = true)
	public long countByDateTimeAndMonthly(String endDate);
	
	@Query("{'dateTime' : { $lte: ?0}}")
	List<Gps> deleteAllByDateTimeAndMonthly(String endDate);

}
