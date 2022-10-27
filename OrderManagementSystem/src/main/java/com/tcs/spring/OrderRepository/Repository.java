package com.tcs.spring.OrderRepository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.spring.OrderModel.Orders; 

public interface Repository extends JpaRepository<Orders,Integer>{

}
