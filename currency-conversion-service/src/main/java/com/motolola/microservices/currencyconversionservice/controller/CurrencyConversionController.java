package com.motolola.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.motolola.microservices.currencyconversionservice.CurrencyExchangeServiceProxy;
import com.motolola.microservices.currencyconversionservice.bean.CurrencyConversionBean;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	
	@GetMapping("currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, 
			@PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		String url = "http://localhost:8000/currency-exchange/from/"+from+"/to/"+to;
		ResponseEntity<CurrencyConversionBean> responseEntity = 
				new RestTemplate().getForEntity(url, CurrencyConversionBean.class);		

		CurrencyConversionBean response = responseEntity.getBody();
		 
		return new CurrencyConversionBean(response.getId(), from, to, 
				response.getConversionMultiple(), 
				quantity, quantity.multiply(response.getConversionMultiple()), response.getPort());
		
	}
	
	@GetMapping("currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean converCurrencyFeign(@PathVariable String from, 
			@PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		CurrencyConversionBean response = proxy.convertCurrency(from, to);
		 
		return new CurrencyConversionBean(response.getId(), from, to, 
				response.getConversionMultiple(), 
				quantity, quantity.multiply(response.getConversionMultiple()), response.getPort());
		
	}

}
