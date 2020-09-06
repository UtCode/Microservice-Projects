package com.in28minutes.microservices.currencyconversionservice;

import java.math.BigDecimal;

public class CurrencyConversionBean {
	
	private long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private BigDecimal quantity;
	private BigDecimal totalCalculatedAmount;
	private int port;
	
	public CurrencyConversionBean() {
		
	}
	
	public CurrencyConversionBean(long id, String from, String to, BigDecimal conversionMultiple, BigDecimal quantity,
			BigDecimal totalCaclAmount,int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
		this.totalCalculatedAmount = totalCaclAmount;
		this.port = port;
	}
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotalCaclAmount() {
		return totalCalculatedAmount;
	}
	public void setTotalCaclAmount(BigDecimal totalCaclAmount) {
		this.totalCalculatedAmount = totalCaclAmount;
	}

}
