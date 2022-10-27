package com.tcs.springboot.patientmodel;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data  
@AllArgsConstructor  
@NoArgsConstructor
@Entity
@Table
public class Patient {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer patientId;
	@Column
	private String patientName;
	@Column
	private String patientDisease;
	@Column
	private Integer patientAge;	
}
