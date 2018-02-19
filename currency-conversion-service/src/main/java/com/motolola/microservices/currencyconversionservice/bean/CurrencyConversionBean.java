package com.motolola.microservices.currencyconversionservice.bean;

import java.math.BigDecimal;

import org.apache.el.lang.ELArithmetic.LongDelegate;

public class CurrencyConversionBean {
	
	private Long id;
	private String from;
	private String to;
	private BigDecimal convesionMultiple;
	private BigDecimal quantity;
	private BigDecimal totalCalculatedAmount;
	private int port;
	
	public CurrencyConversionBean() {
		
	}
	public CurrencyConversionBean(Long id, String from, String to, BigDecimal convesionMultiple, BigDecimal quantity,
			BigDecimal totalCalculatedAmount, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.convesionMultiple = convesionMultiple;
		this.quantity = quantity;
		this.totalCalculatedAmount = totalCalculatedAmount;
		this.port = port;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConvesionMultiple() {
		return convesionMultiple;
	}
	public void setConvesionMultiple(BigDecimal convesionMultiple) {
		this.convesionMultiple = convesionMultiple;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}
	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	

}
