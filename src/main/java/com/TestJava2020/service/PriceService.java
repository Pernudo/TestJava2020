package com.TestJava2020.service;

import java.util.Date;
import java.util.Optional;

import com.TestJava2020.model.Price;

public interface PriceService {

	Price savePrice(Price price);
	
	Optional<Price> getPrice(Date date, int productId, int brandId);
}
