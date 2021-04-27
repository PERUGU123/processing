package com.stockexchange.model;


import java.io.Serializable;
/**
 * This is an entity class for StockExchange module with getters and setters
 * 
 * Many to many mapping with stock
 * 
 */
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class StockExchange implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 634865347586834493L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int StockExchangeId;

	@Column(name = "stockExchange_name")
	private String stockExchangeName;

	@ManyToMany(mappedBy = "stockExchange")
	private List<Stock> stocks;

	public int getStockExchangeId() {
		return StockExchangeId;
	}

	public void setStockExchangeId(int stockExchangeId) {
		StockExchangeId = stockExchangeId;
	}

	public String getStockExchangeName() {
		return stockExchangeName;
	}

	public void setStockExchangeName(String stockExchangeName) {
		this.stockExchangeName = stockExchangeName;
	}

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

}

