package com.rakesh.microservice.limitsservice.Configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limits-service")
public class LimitsConfiguration {

	
	private int minimum;
	private int maximum;
	public int getMinimum() {
		return minimum;
	}
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	public LimitsConfiguration(int minimum, int maximum) {
		this.minimum = minimum;
		this.maximum = maximum;
	}
	public LimitsConfiguration() {
	}
	
	
	
	
}
