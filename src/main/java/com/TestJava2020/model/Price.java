package com.TestJava2020.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "PRICES")
public class Price {
	
	public Price(){}

	// Foreign key de la cadena del grupo (1 = ZARA). 1
	@Column(name = "brand_id", nullable = false)
	private int brandId;
	
	// Rango de fechas en el que aplica el precio tarifa indicado. 2020-06-14-00.00.00
	@Column(name = "start_date", nullable = false)
	@DateTimeFormat(pattern="yyy-MM-dd-HH.mm.ss")
	private Date startDate; 
	
	// Rango de fechas en el que aplica el precio tarifa indicado. 2020-12-31-23.59.59
	@Column(name = "end_date", nullable = false)
	@DateTimeFormat(pattern="yyy-MM-dd-HH.mm.ss")
	private Date endDate;

	// Identificador de la tarifa de precios aplicable. 1
	@Id
	@Column(name = "price_list", nullable = false)
	private int priceList; 

	// Identificador código de producto. 35455
	@Column(name = "product_id", nullable = false)
	private int productId;
	
	// Desambiguador de aplicación de precios. Si dos tarifas coinciden en un rago de fechas se aplica la de mayor prioridad (mayor valor numérico). 0
	@Column(name = "priority", nullable = false)
	private int priority;
	
	// Precio final de venta. 35.50
	@Column(name = "price", nullable = false)
	private double price;
	
	// Iso de la moneda. EUR
	@Column(name = "curr", nullable = false, length = 3)
	private String curr;

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
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

	public int getPriceList() {
		return priceList;
	}

	public void setPriceList(int priceList) {
		this.priceList = priceList;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCurr() {
		return curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}

	public Price(int brandId, Date startDate, Date endDate, int priceList, int productId, int priority, double price,
			String curr) {
		super();
		this.brandId = brandId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priceList = priceList;
		this.productId = productId;
		this.priority = priority;
		this.price = price;
		this.curr = curr;
	}

	@Override
	public String toString() {
		return "Price [brandId=" + brandId + ", startDate=" + startDate + ", endDate=" + endDate + ", priceList="
				+ priceList + ", productId=" + productId + ", priority=" + priority + ", price=" + price + ", curr="
				+ curr + "]";
	}
	
}
