package com.tcs.spring.OrderServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tcs.spring.OrderModel.Orders;
import com.tcs.spring.OrderRepository.Repository;
import com.tcs.spring.OrderService.Services;
import com.tcs.springboot.patientmodel.Patient;

import lombok.RequiredArgsConstructor;

@Service
public class ServiceImpl implements Services{
	
	private RestTemplate restTemplate;
	
//	@Value("${patient.management.url}")
//	private String url;
	
    @Autowired
    public ServiceImpl(RestTemplate restTemplate) {
        this.restTemplate=restTemplate;
    }
    
    public Patient consumeApi(int id) {
    	String url="http://localhost:8082/api/getpatient/"+Integer.toString(id);
    	url=url+Integer.toString(id);
        return restTemplate.getForObject(url, Patient.class);
    }
    @Autowired
    private Repository repository;
	public List<Orders> getAllOrders()   
	{  
	return repository.findAll();  
	}  

	
	public void saveOrder(Orders orders)   
	{  
	//patient=
			repository.save(orders);
	//return patient.getPatientId();
	}  
	public List<Orders> removeOrder(int id){
		repository.deleteById(id);
		return repository.findAll();
	}
	public Integer update(Orders orders,int id) {
		
		repository.save(orders);
		return orders.getId();
	}

	@Override
	public Orders getOrderById(int id) {
		return repository.findById(id).orElse(null); 
	}
}
