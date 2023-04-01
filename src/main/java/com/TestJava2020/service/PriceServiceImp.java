package com.TestJava2020.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TestJava2020.model.Price;
import com.TestJava2020.repository.PriceRepository;

@Service
public class PriceServiceImp implements PriceService{

	@Autowired
	private PriceRepository priceRepository;
	
	@Override
	public Price savePrice(Price price) {
		return priceRepository.save(price);
	}

	@Override
	public Price getPrice(Date date, int productId, int brandId) {
		List<Price> lstPrices = priceRepository.findPrice(date, productId, brandId);
		
		// Como tenemos ordenado por prioridad, seleccionamos el primer registro
		return lstPrices.size()>0 ? lstPrices.get(0) : null;
	}

}
