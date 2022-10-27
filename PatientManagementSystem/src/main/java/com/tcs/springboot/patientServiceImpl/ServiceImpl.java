package com.tcs.springboot.patientServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.springboot.patientmodel.Patient;
import com.tcs.springboot.patientrepository.Repository;
import com.tcs.springboot.patientservice.Services;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class ServiceImpl implements Services{
	@Autowired
	private Repository repository;
	
	public List<Patient> getAllPatient()   
	{  
	return repository.findAll();
	}  
	//getting a specific record  
	public Patient getPatientById(int id)   
	{  
	return repository.findById(id).orElse(null);  
	}  
	public Integer savePatient(Patient patient)   
	{ 
		repository.save(patient);
		return patient.getPatientId();
	}  
	public List<Patient> removePatient(int id){
		repository.deleteById(id);
		return repository.findAll();
	}
	public Integer update(Patient patient,int id) {
		
		repository.deleteById(id);
		patient.setPatientId(id);
		repository.save(patient);
		return patient.getPatientId();
	}
}
