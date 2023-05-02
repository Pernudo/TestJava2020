package com.TestJava2020.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PriceResponse {
	
	public PriceResponse(){}
		
	private int productId;
	private int brandId;
	private int priceList;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Europe/Madrid")
	private Date startDate;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Europe/Madrid")
	private Date endDate;
	private double price;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public int getPriceList() {
		return priceList;
	}
	public void setPriceList(int priceList) {
		this.priceList = priceList;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public PriceResponse(Price price) {
		super();
		this.productId = price.getProductId();
		this.brandId = price.getBrandId();
		this.priceList = price.getPriceList();
		this.startDate = price.getStartDate();
		this.endDate = price.getEndDate();
		this.price = price.getPrice();
	}	
}
