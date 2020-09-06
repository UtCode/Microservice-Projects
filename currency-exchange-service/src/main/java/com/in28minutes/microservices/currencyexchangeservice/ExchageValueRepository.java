package com.in28minutes.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchageValueRepository extends JpaRepository<ExchangeValue,Long> {
	ExchangeValue findByFromAndTo(String from,String to);
}
