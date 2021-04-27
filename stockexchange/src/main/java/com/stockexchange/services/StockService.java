package com.stockexchange.services;

import java.util.List;

import com.stockexchange.model.Stock;
import com.stockexchange.model.StockExchange;

public interface StockService {
	
	/**Create a manager
	 * @param manager
	 * @return
	 */
	Stock createStock(Stock stocks);
	
	/**Update manager details
	 * @param managerId
	 * @param managerDetails
	 * @return
	 * @throws ResourceNotFoundException
	 */
	Stock updateStock(int stockId, Stock stock);
//	throws ResourceNotFoundException;
	
	/**delete Manager from data base 
	 * @param managerId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	boolean deleteStock(int stockId);
//	throws ResourceNotFoundException;
	
	/**Lists all managers available
	 * @return
	 */
	List<Stock> getAllStocks();
	
	/**finds manager by his/her ID
	 * @param managerId
	 * @return
	 */
	Stock getStockById(int stockId);
	 
}