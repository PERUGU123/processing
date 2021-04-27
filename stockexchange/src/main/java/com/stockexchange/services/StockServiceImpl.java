package com.stockexchange.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.stockexchange.model.Stock;
import com.stockexchange.model.StockExchange;
import com.stockexchange.repo.StockRepository;

@Service
@Transactional
public class StockServiceImpl implements StockService {

	@Autowired
	private StockRepository stockRepository;

	/**
	 * Create Stock in data base
	 * 
	 * @param stock
	 */
	@Override
	public Stock createStock(Stock stocks) {
		return stockRepository.save(stocks);
	}

	/**
	 * Update Stock details
	 * 
	 * @param stockId
	 */
	@Override
	public Stock updateStock(@PathVariable(value = "stockId") int stockId, @RequestBody Stock stocks) {
//					 throws ResourceNotFoundException {
		Stock stock = stockRepository.findById(stockId).orElseThrow();
//				(() -> new ResourceNotFoundException("Company Manager not found for this id :: " + managerId));
		stock.setStockId(stocks.getStockId());
		stock.setStockExchange(stocks.getStockExchange());
		final Stock updatedStock = stockRepository.save(stock);
		return updatedStock;

	}

	/**
	 * delete stock from database
	 * 
	 * @param stockId
	 */
	@Override
	public boolean deleteStock(@PathVariable(value = "id") int stockId) {
//		throws ResourceNotFoundException {
		Stock stock = stockRepository.findById(stockId).orElseThrow();
//					() -> new ResourceNotFoundException(" Manager not found for this id :: " + managerId));
		stockRepository.delete(stock);
		return true;
	}

	/**
	 * gets the list of all stocks
	 */
	@Override
	public List<Stock> getAllStocks() {
		return stockRepository.findAll();

	}

	@Override
	public Stock getStockById(int stockId) {
		return stockRepository.getOne(stockId);
	}

}