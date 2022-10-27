package com.tcs.spring.OrderMapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.tcs.spring.OrderDto.OrdersDto;
import com.tcs.spring.OrderModel.Orders;
import com.tcs.springboot.patientmapper.PatientMapper;

@Mapper
public interface OrdersMapper {
	OrdersMapper instance=Mappers.getMapper(OrdersMapper.class);
	@Mappings({
        @Mapping(source = "patient.id", target = "orderId"),
        @Mapping(source = "patient.name", target = "orderName"),
        @Mapping(source = "patient.description", target = "orderDescription"),
        @Mapping(source = "patient.patientId", target = "orderPatientId"),
        @Mapping(source = "patient.patientName", target = "orderPatientName")})
    OrdersDto toOrderPatientDto(Orders orders);

    @Mappings({
        @Mapping(source = "patientDto.orderId", target = "id"),
        @Mapping(source = "patientDto.orderName", target = "name"),
        @Mapping(source = "patientDto.orderDescription", target = "description"),
        @Mapping(source = "patientDto.orderPatientId", target = "patientId"),
        @Mapping(source = "patientDto.orderPatientName", target = "patientName")})
    Orders toOrderPatienEntity(OrdersDto ordersDto);
}
