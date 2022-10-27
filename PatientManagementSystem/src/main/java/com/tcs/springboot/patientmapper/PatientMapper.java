package com.tcs.springboot.patientmapper;


import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.tcs.springboot.PatientDTO.PatientDto;
import com.tcs.springboot.patientmodel.Patient;

@Mapper
public interface PatientMapper {
	PatientMapper instance=Mappers.getMapper(PatientMapper.class);

	/*
	 * @Mappings({
	 * 
	 * @Mapping(source="patientId",target="patientId"),
	 * 
	 * @Mapping(source="patientName",target="patientName"),
	 * 
	 * @Mapping(source="patientDisease",target="patientDisease"),
	 * 
	 * @Mapping(source="patientFee",target="patientFee") })
	 */
	Patient toPatient(PatientDto patientDto);
	/*
	 * @Mappings({
	 * 
	 * @Mapping(source="patientDto.patientId",target="patientId"),
	 * 
	 * @Mapping(source="patientDto.patientName",target="patientName"),
	 * 
	 * @Mapping(source="patientDto.patientDisease",target="patientDisease"),
	 * 
	 * @Mapping(source="patientDto.patientFee",target="patientFee") })
	 */
	@InheritInverseConfiguration
	PatientDto toPatientDto(Patient patient);
}
