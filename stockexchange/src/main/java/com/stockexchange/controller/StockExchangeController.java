package com.stockexchange.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockexchange.model.Stock;
import com.stockexchange.model.StockExchange;
import com.stockexchange.services.StockExchangeService;
import com.stockexchange.services.StockService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/exchanges")
public class StockExchangeController {
	
	@Autowired
	private StockExchangeService stockExchangeService;
	
	@Autowired
	private StockService stockService;
	
	/**Display list of employees using GET method
	 * @return
	 */
	@GetMapping("/all")
//	@ApiOperation(value = "get all employees ", response = Iterable.class, tags = "EmployeeControllerClass")
	public List<StockExchange> getAllExchanges() {
		return stockExchangeService.getAllExchanges();
	}
	
	/**Insert details of employee using POST method
	 * @param employee
	 * @param managerId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@PostMapping("/{exchangeId}")
//	@ApiOperation(value = "save employee ", response = Employee.class, tags = "EmployeeControllerClass")
	public ResponseEntity<StockExchange> createExchange( @RequestBody StockExchange stockExchange,@PathVariable("stockId") int stockId){
//		throws ResourceNotFoundException {
	
		Stock stock = stockService.getStockById(stockId);
		if(stock!=null)
			stockExchange.setStocks((List<Stock>) stock);
		else {
			
		}
		
		return ResponseEntity.ok(stockExchangeService.createExchange(stockExchange));
	}
	
	/**Update employee details using PUT method
	 * @param employeeId
	 * @param employeeDetails
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@PutMapping("/{id}")
//	@ApiOperation(value = "update employee details ", response = Employee.class, tags = "EmployeeControllerClass")
	public ResponseEntity<StockExchange> updateExchange(@PathVariable(value = "id") int exchangeId,
						@RequestBody StockExchange stockExchange){
//								throws ResourceNotFoundException {
		StockExchange  stockExchanges = stockExchangeService.updateExchange(exchangeId, stockExchange);
//		log.info("updated employee");
		return  ResponseEntity.ok(stockExchanges);
	}
	
	/**Delete employee details using DELETE method
	 * @param employeeId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@DeleteMapping("/deleteEmployee/{id}")
//	@ApiOperation(value = "update employee details", response = Employee.class, tags = "EmployeeControllerClass")
	public ResponseEntity<Boolean> deleteExchangeById(@PathVariable(value = "id") int exchangeId){
//						throws ResourceNotFoundException{
//		log.info("deleted employee");
		return ResponseEntity.ok(stockExchangeService.deleteExchangeById(exchangeId));
	}
	
	/**display employee details by GET method
	 * @param empId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/getById/{id}")
//	@ApiOperation(value = "fetch employee by id", response = Employee.class, tags = "EmployeeControllerClass")
	public StockExchange getEmployeeById(@PathVariable(value="id")int exchangeId) {
//		throws ResourceNotFoundException{
//		log.info("fetched employee with id "+empId);
		return stockExchangeService.getExchangeById(exchangeId);
	}
}
