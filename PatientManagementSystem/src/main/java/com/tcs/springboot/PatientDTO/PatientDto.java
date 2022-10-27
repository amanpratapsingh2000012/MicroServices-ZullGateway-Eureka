package com.tcs.springboot.PatientDTO;


import lombok.Data;

@Data
public class PatientDto {
	private Integer patientId;
	private String patientName;
	private String patientDisease;
	private Integer patientAge;	
}
