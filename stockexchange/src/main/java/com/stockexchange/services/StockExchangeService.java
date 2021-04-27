package com.stockexchange.services;

import java.util.List;

import com.stockexchange.model.StockExchange;

public interface StockExchangeService {
		StockExchange createExchange(StockExchange exchange); 
//				throws ResourceNotFoundException;
	
	/**Update Employee details
	 * @param employeeId
	 * @param employeeDetails
	 * @return
	 * @throws ResourceNotFoundException
	 */
		StockExchange updateExchange(int exchangeId, StockExchange stockExchange); 
//				throws ResourceNotFoundException;
	
	/**Delete an employee
	 * @param employeeId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	boolean deleteExchangeById(int exchangeId);
//	throws ResourceNotFoundException;
	
	/**Display list of employees
	 * @return
	 */
	List<StockExchange> getAllExchanges();
	
	/**Find employee using his/her ID
	 * @param empId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	StockExchange getExchangeById(int exchangeId);
//	throws ResourceNotFoundException;

}
