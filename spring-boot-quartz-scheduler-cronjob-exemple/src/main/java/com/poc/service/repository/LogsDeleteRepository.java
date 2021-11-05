package com.poc.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.poc.model.LogsDelete;

@Repository
public interface LogsDeleteRepository extends CrudRepository<LogsDelete, Integer> {

}
