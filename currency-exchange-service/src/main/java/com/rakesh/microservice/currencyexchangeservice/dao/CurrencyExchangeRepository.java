package com.rakesh.microservice.currencyexchangeservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rakesh.microservice.currencyexchangeservice.dto.CurrenyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrenyExchange, Long> {

	CurrenyExchange findByFromAndTo(String from,String to);
}
