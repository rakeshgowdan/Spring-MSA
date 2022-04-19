package com.rakesh.microservice.currencyconversionservice.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyConversion {

	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private String environment;
	private int quantity;
	private BigDecimal totalCalculatedAmount;
}
