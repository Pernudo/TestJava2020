package com.TestJava2020.service;

import java.util.Date;

import com.TestJava2020.model.Price;

public interface PriceService {

	Price savePrice(Price price);
	
	Price getPrice(Date date, int productId, int brandId);
}
