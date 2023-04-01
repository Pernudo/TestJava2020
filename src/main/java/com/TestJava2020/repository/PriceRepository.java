package com.TestJava2020.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.TestJava2020.model.Price;

public interface PriceRepository extends JpaRepository<Price, Integer>{

	// SELECT * FROM Prices p WHERE p.start_Date < PARSEDATETIME('2020-06-14 10:00:00','yyyy-MM-dd HH:mm:ss') and p.end_Date >= PARSEDATETIME('2020-06-14 10:00:00','yyyy-MM-dd HH:mm:ss') and p.product_Id = 35455 and p.brand_Id = 1 order by p.priority desc
	@Query("SELECT p FROM Price p WHERE p.startDate < PARSEDATETIME(?1,'yyyy-MM-dd HH:mm:ss') and p.endDate >= PARSEDATETIME(?1,'yyyy-MM-dd HH:mm:ss') and p.productId = ?2 and p.brandId = ?3 order by p.priority desc")
	List<Price> findPrice(Date date, int productId, int brandId);

}
