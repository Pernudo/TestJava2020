package com.TestJava2020.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.TestJava2020.model.Price;
import com.TestJava2020.service.PriceService;

@RestController
@RequestMapping("/price")
public class PriceController {

	@Autowired
	private PriceService priceServ;
	
	// http://localhost:8080/price?date=2020-06-14-10.00.00&productId=35455&brandId=1
	// Acepte como parámetros de entrada: fecha de aplicación, identificador de producto, identificador de cadena.
	// Devuelva como datos de salida: identificador de producto, identificador de cadena, tarifa a aplicar, fechas de aplicación y precio final a aplicar.
	@GetMapping
	@ResponseBody
	public String price(@RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd-HH.mm.ss") Date date, @RequestParam int productId, @RequestParam int brandId) throws ParseException {
		StringJoiner resp = new StringJoiner(",");
		
		// Consultamos en la BBDD
		Price price = priceServ.getPrice(date, productId, brandId);
		
		// Montamos la respuesta
		resp.add(String.valueOf(price.getProductId()));
		resp.add(String.valueOf(price.getBrandId()));
		resp.add(String.valueOf(price.getPriceList()));
		resp.add(String.valueOf(price.getStartDate()));
		resp.add(String.valueOf(price.getEndDate()));
		resp.add(String.valueOf(price.getPrice()));

		return resp.toString();
	}

}
