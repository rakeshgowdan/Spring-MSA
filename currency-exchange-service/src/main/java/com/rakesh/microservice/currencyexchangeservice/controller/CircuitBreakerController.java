package com.rakesh.microservice.currencyexchangeservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CircuitBreakerController {

	
	@GetMapping("/sample-cb")
	@Retry(name="sample-api",fallbackMethod="fallBackResoponse")
	public String sampleAPI() {
		log.info("CB | Sample cb called ");
		
		ResponseEntity<String> res= new RestTemplate().getForEntity("http://localhost:8000/", String.class);
		return res.getBody();
	}
	
	public String fallBackResoponse(Exception ex) {
	 return "Fallback Response";
	}
}
