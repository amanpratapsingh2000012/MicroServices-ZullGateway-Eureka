package com.tcs.spring.Ordercontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.spring.OrderMapper.OrdersMapper;
import com.tcs.spring.OrderModel.Orders;
import com.tcs.spring.OrderService.Services;
import com.tcs.springboot.patientmodel.Patient;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api")
public class Controller {
	private Services services;
	
	@Autowired
    public Controller(Services services) {
        this.services=services;
    }
	@GetMapping("/")
    private List<Orders> get() {
        List<Orders> o=services.getAllOrders();
        return o;
    }

	@ApiOperation(value="Getting All Orders")
	@GetMapping("/allorder")  
	public List<Orders> getAllOrder()   
	{  
	return services.getAllOrders();  
	}  
	
	
	@ApiOperation(value="Getting patient details based on Id")
	@GetMapping("/getorder/{id}")  
	public Orders getOrder(@PathVariable int id)   
	{  	Orders o=services.getOrderById(id);
		return o;  
	}
	
	
	//@RequestMapping(value = "patient/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Adding patient details")
	@PostMapping("/addorder/{id}")
	public ResponseEntity<String> saveOrder(@RequestBody Orders orders,@PathVariable int id)   
	{  
		ResponseEntity<String> response=null;
		Patient p=services.consumeApi(id);
		orders.setPatientId(p.getPatientId());
		orders.setPatientName(p.getPatientName());
		services.saveOrder(orders);
		String msg="Order is saved";
		response=new ResponseEntity<String>(msg,HttpStatus.OK);
		return response;
	}
	
	
	@ApiOperation(value="For Deleting patient details")
	@DeleteMapping("/delete/{id}")
	public List<Orders> delete(@PathVariable int id){
		return services.removeOrder(id);
	}
	@PutMapping("/addpatient/{id}")
	/**
	 * public Integer update(@RequestBody Patient patient,int id) {
	 * services.savePatient(patient); }
	 */
	@ApiOperation(value="Description")
	@GetMapping("/description")
	public String description() {
		return "This Application is made for storing Patients Details";
	}
}
