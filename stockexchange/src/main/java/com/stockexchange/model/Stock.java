package com.stockexchange.model;

/**This is the entity class for Stock with getters and setters
 * 
 * Many to many relation with stock exchange
 */

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.*;

@Entity
public class Stock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stockId;
	
	@Column(name = "stock_name")
	private String stockName;

	@ManyToMany(fetch = FetchType.LAZY,cascade = { CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "exchangeId")
	private List<StockExchange> stockExchange;

	public Stock() {
		super();
	}

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public List<StockExchange> getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(List<StockExchange> stockExchange) {
		this.stockExchange = stockExchange;
	}


}