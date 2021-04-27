package com.stockexchange.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockexchange.model.StockExchange;

@Repository
public interface StockExchangeRepository extends  JpaRepository<StockExchange, Integer>  {
		
}
