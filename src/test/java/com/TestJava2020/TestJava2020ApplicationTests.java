package com.TestJava2020;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class TestJava2020ApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	// Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
	@Test
	public void test01() throws Exception {
		this.mockMvc.perform(get("/price?date=2020-06-14-10.00.00&productId=35455&brandId=1")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().string(containsString("35455,1,1,2020-06-14 00:00:00.0,2020-12-31 23:59:59.0,35.5")));
	}
	
	// Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
	@Test
	public void test02() throws Exception {
		this.mockMvc.perform(get("/price?date=2020-06-14-16.00.00&productId=35455&brandId=1")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().string(containsString("35455,1,2,2020-06-14 15:00:00.0,2020-06-14 18:30:00.0,25.45")));
	}
	
	// Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
	@Test
	public void test03() throws Exception {
		this.mockMvc.perform(get("/price?date=2020-06-14-21.00.00&productId=35455&brandId=1")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().string(containsString("35455,1,1,2020-06-14 00:00:00.0,2020-12-31 23:59:59.0,35.5")));
	}
	
	// Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
	@Test
	public void test04() throws Exception {
		this.mockMvc.perform(get("/price?date=2020-06-15-10.00.00&productId=35455&brandId=1")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().string(containsString("35455,1,3,2020-06-15 00:00:00.0,2020-06-15 11:00:00.0,30.5")));
	}
	
	// Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
	@Test
	public void test05() throws Exception {
		this.mockMvc.perform(get("/price?date=2020-06-16-21.00.00&productId=35455&brandId=1")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().string(containsString("35455,1,4,2020-06-15 16:00:00.0,2020-12-31 23:59:59.0,38.95")));
	}

}
