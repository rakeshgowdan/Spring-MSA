package com.rakesh.microservice.currencyconversionservice.configuration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rakesh.microservice.currencyconversionservice.dto.CurrencyConversion;


@FeignClient(name="currency-exchange-service",url="localhost:8000")
public interface CurrencyExchangeProxy {

	@GetMapping("api/v1/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion convertCurrency(@PathVariable String from,@PathVariable String to); 
	
}
