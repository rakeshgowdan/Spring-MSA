package com.rakesh.microservice.currencyexchangeservice.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rakesh.microservice.currencyexchangeservice.dao.CurrencyExchangeRepository;
import com.rakesh.microservice.currencyexchangeservice.dto.CurrenyExchange;

@RestController
@RequestMapping("/api/v1/currency-exchange")
public class CurrencyRateController {

	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;
	
	
	@GetMapping("/from/{from}/to/{to}")
	public CurrenyExchange convertCurrency(@PathVariable String from,@PathVariable String to) {
		String port = environment.getProperty("local.server.port");
		CurrenyExchange currenyExchange=currencyExchangeRepository.findByFromAndTo(from, to);
		if(currenyExchange==null) {
			throw new RuntimeException("Unable to find data of "+from +" "+to);
		}
		currenyExchange.setEnvironment(port);
		
		return currenyExchange;
	}
}
