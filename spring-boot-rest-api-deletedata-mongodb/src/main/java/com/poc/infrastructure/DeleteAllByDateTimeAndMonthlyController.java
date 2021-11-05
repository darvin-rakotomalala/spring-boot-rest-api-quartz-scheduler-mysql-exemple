package com.poc.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.service.metier.DeleteAllByDateTimeAndMonthlySM;

@RestController
public class DeleteAllByDateTimeAndMonthlyController {

	@Autowired
	private DeleteAllByDateTimeAndMonthlySM deleteAllByDateTimeAndMonthlySM;
	
	@DeleteMapping("/deletebydatetime")
	public String deleteAllByDateTimeAndMonthly(
			@RequestParam(name = "endDate", required = false) String endDate,
			@RequestParam(name = "month", defaultValue = "3", required = true) String month,
			@RequestParam(name = "paquet", defaultValue = "50") int paquet) {
		deleteAllByDateTimeAndMonthlySM.deleteAllByDateTimeAndMonthly(endDate, month, paquet);
		return "Data deleted successfully !";
	}

}
