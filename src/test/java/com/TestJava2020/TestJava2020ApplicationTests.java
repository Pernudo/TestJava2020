package com.TestJava2020;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@SpringBootTest
@AutoConfigureMockMvc
class TestJava2020ApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	// Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
	@Test
	public void test01() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("date", "2020-06-14-10.00.00");
		params.add("productId", "35455");
		params.add("brandId", "1");
		
		this.mockMvc.perform(get("/price").params(params))
		.andDo(print()).andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.productId").value("35455"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value("1"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value("1"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-14 00:00:00"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-12-31 23:59:59"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.price").value("35.5"));
	}
	
	// Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
	@Test
	public void test02() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("date", "2020-06-14-16.00.00");
		params.add("productId", "35455");
		params.add("brandId", "1");
		
		this.mockMvc.perform(get("/price").params(params))
		.andDo(print()).andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.productId").value("35455"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value("1"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value("2"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-14 15:00:00"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-06-14 18:30:00"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.price").value("25.45"));
	}
	
	// Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
	@Test
	public void test03() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("date", "2020-06-14-21.00.00");
		params.add("productId", "35455");
		params.add("brandId", "1");
		
		this.mockMvc.perform(get("/price").params(params))
		.andDo(print()).andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.productId").value("35455"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value("1"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value("1"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-14 00:00:00"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-12-31 23:59:59"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.price").value("35.5"));
	}
	
	// Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
	@Test
	public void test04() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("date", "2020-06-15-10.00.00");
		params.add("productId", "35455");
		params.add("brandId", "1");
		
		this.mockMvc.perform(get("/price").params(params))
		.andDo(print()).andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.productId").value("35455"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value("1"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value("3"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-15 00:00:00"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-06-15 11:00:00"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.price").value("30.5"));
	}
	
	// Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
	@Test
	public void test05() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("date", "2020-06-16-21.00.00");
		params.add("productId", "35455");
		params.add("brandId", "1");
		
		this.mockMvc.perform(get("/price").params(params))
		.andDo(print()).andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.productId").value("35455"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value("1"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value("4"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-15 16:00:00"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-12-31 23:59:59"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.price").value("38.95"));
	}

}
