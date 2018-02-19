package com.motolola.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.motolola.microservices.currencyconversionservice.bean.CurrencyConversionBean;

@RestController
public class CurrencyConversionController {
	@GetMapping("currency-service/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean converCurrency(@PathVariable String from, 
			@PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		return new CurrencyConversionBean(1L, from, to, BigDecimal.ONE, quantity, quantity, 0);
		
	}

}
