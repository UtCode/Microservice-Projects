package com.in28minutes.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
											@PathVariable BigDecimal quantity) {
		
		// Step-1 Hard coded response
		//return new CurrencyBean(1L, from, to, BigDecimal.ONE, quantity, quantity, 0);
		
		// Step-2 calling currency exchange service for /currency-exchange/from/{from}/to/{to} through rest template
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to",to);
		 
		ResponseEntity<CurrencyConversionBean> responseEnity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
				CurrencyConversionBean.class, uriVariables);
		
		CurrencyConversionBean response = responseEnity.getBody();
		
		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
					quantity.multiply(response.getConversionMultiple()), response.getPort());	
	}
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
											@PathVariable BigDecimal quantity) {
		
		// calling currency exchange service for /currency-exchange/from/{from}/to/{to} through feign
		CurrencyConversionBean response = currencyExchangeServiceProxy.retrieveExchangeValue(from, to);
		
		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
					quantity.multiply(response.getConversionMultiple()), response.getPort());	
	}
}
