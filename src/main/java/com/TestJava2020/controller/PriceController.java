package com.TestJava2020.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.TestJava2020.model.Price;
import com.TestJava2020.model.PriceResponse;
import com.TestJava2020.service.PriceService;

@RestController
@RequestMapping("/")
public class PriceController {

	@Autowired
	private PriceService priceServ;
	
	// http://localhost:8080/price?date=2020-06-14-10.00.00&productId=35455&brandId=1
	// Acepte como parámetros de entrada: fecha de aplicación, identificador de producto, identificador de cadena.
	// Devuelva como datos de salida: identificador de producto, identificador de cadena, tarifa a aplicar, fechas de aplicación y precio final a aplicar.
	@GetMapping("/price")
	@ResponseBody
	public PriceResponse price(@RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd-HH.mm.ss") Date date, @RequestParam int productId, @RequestParam int brandId) throws ParseException {
		
		// Consultamos en la BBDD
		Optional<Price> price = priceServ.getPrice(date, productId, brandId);
		
		// Montamos la respuesta
		PriceResponse priceResp = new PriceResponse();
		if(price.isPresent()) {
			priceResp = new PriceResponse(price.get());
		}

		return priceResp;
	}

}
