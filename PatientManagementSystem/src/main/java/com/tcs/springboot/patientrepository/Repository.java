package com.tcs.springboot.patientrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.springboot.patientmodel.Patient; 

public interface Repository extends JpaRepository<Patient,Integer>{

}
