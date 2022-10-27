package com.tcs.spring.OrderDto;


import lombok.Data;

@Data
public class OrdersDto {
	private int orderId;

    private String orderName;

    private String orderDescription;

    private int orderPatientId;

    private String orderPatientName;	
}
