package com.stockexchange.services;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockexchange.model.Stock;
import com.stockexchange.model.StockExchange;
import com.stockexchange.repo.StockExchangeRepository;

@Service
@Transactional
public class StockExchangeServiceImpl implements StockExchangeService{
	@Autowired
	private StockExchangeRepository stockExchangeRepository;
		
	@Autowired
	private StockService stockService;

	@Override
	public StockExchange createExchange(StockExchange stockExchange) {
		Stock stock = stockService.getStockById(((Stock) stockExchange.getStocks()).getStockId());
		stock.getStockExchange().add(stockExchange); 
		stockService.updateStock(stock.getStockId(),stock);
		return  stockExchangeRepository.save(stockExchange);
	}
	
	@Override
	public StockExchange updateExchange(int exchangeId, StockExchange stockExchange) {
		StockExchange stockExchanges = stockExchangeRepository.findById(exchangeId).orElseThrow();
//		() -> new ResourceNotFoundException("Updation not possible as employee not found for this id :: " + employeeId ));
		stockExchanges.setStockExchangeName(stockExchange.getStockExchangeName());
		stockExchanges.setStocks(stockExchange.getStocks());
		final StockExchange updatedExchange = stockExchangeRepository.save(stockExchanges);
		return updatedExchange; 
	}

	@Override
	public boolean deleteExchangeById(int exchangeId) {
		StockExchange stockExchange = stockExchangeRepository.findById(exchangeId).orElseThrow();
//				() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		stockExchangeRepository.delete(stockExchange);
		return true;
	}

	@Override
	public List<StockExchange> getAllExchanges() {
		return stockExchangeRepository.findAll();
	}

	@Override
	public StockExchange getExchangeById(int exchangeId) {
		StockExchange stockExchange = stockExchangeRepository.findById(exchangeId).orElseThrow();
//				() -> new ResourceNotFoundException("Employee not found for this id :: " + empId));
		return stockExchange;
	}

	
}

