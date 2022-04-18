package com.rakesh.microservice.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rakesh.microservice.limitsservice.Configuration.LimitsConfiguration;
import com.rakesh.microservice.limitsservice.dto.Limits;

@RestController
@RequestMapping("/limits-service")
public class LimitsController {
	
	@Autowired
	private LimitsConfiguration config;
	
	@GetMapping("/limits")
	public Limits retrieveLimits() {
		//return new Limits(1,1000);
		return new Limits(config.getMinimum(),config.getMaximum());
	}

}
