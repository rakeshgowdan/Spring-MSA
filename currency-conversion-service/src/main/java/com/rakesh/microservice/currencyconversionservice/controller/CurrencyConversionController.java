package com.rakesh.microservice.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rakesh.microservice.currencyconversionservice.configuration.CurrencyExchangeProxy;
import com.rakesh.microservice.currencyconversionservice.dto.CurrencyConversion;

@RestController
@RequestMapping("/api/v1/currency-conversion")
public class CurrencyConversionController {

	
	@Autowired
	private CurrencyExchangeProxy proxy;
	
	@GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertToQunatity(@PathVariable String from,@PathVariable String to,@PathVariable int quantity ) {
		
		HashMap<String, String> uriVariables=new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversion> responseEntity=
		new RestTemplate().
		getForEntity("http://localhost:8000/api/v1/currency-exchange/from/{from}/to/{to}", 
				CurrencyConversion.class,uriVariables);
		
		CurrencyConversion currencyConversion= responseEntity.getBody();
		BigDecimal totalConversion = currencyConversion.getConversionMultiple().multiply(BigDecimal.valueOf(quantity));
		return new CurrencyConversion
					(currencyConversion.getId(), 
					 currencyConversion.getFrom(), 
					 currencyConversion.getTo(), 
					 currencyConversion.getConversionMultiple(), 
					 currencyConversion.getEnvironment()+" from rest template ", 
					 quantity, 
					 totalConversion);
	}
	@GetMapping("feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertToQunatityFeign(@PathVariable String from,@PathVariable String to,@PathVariable int quantity ) {
		

		
		CurrencyConversion currencyConversion= proxy.convertCurrency(from, to);
		BigDecimal totalConversion = currencyConversion.getConversionMultiple().multiply(BigDecimal.valueOf(quantity));
		return new CurrencyConversion
					(currencyConversion.getId(), 
					 currencyConversion.getFrom(), 
					 currencyConversion.getTo(), 
					 currencyConversion.getConversionMultiple(), 
					 currencyConversion.getEnvironment()+" from feign ", 
					 quantity, 
					 totalConversion);
	}
}
