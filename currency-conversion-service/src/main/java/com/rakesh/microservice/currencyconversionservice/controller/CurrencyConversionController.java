package com.rakesh.microservice.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rakesh.microservice.currencyconversionservice.dto.CurrencyConversion;

@RestController
@RequestMapping("/api/v1/currency-conversion")
public class CurrencyConversionController {

	
	@GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertToQunatity(@PathVariable String from,@PathVariable String to,@PathVariable int quantity ) {
		//CurrencyConversion currencyConversion = new CurrencyConversion(100L, from, to, BigDecimal.valueOf(111), " ", quantity, BigDecimal.valueOf(1000));
		
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
					 currencyConversion.getEnvironment(), 
					 quantity, 
					 totalConversion);
	}

}
