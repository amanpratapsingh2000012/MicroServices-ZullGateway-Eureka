package com.tcs.springboot.patientcontroller;

import java.util.List;

import java.util.Optional;

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

import com.tcs.springboot.PatientDTO.PatientDto;
import com.tcs.springboot.patientServiceImpl.ServiceImpl;
import com.tcs.springboot.patientmapper.PatientMapper;
import com.tcs.springboot.patientmodel.Patient;
import com.tcs.springboot.patientservice.Services;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api")
public class Controller {
	@Autowired
	private Services services;
	
	@ApiOperation(value="Getting All Patients")
	@GetMapping("/allpatient")  
	public List<Patient> getAllPatient()   
	{  
	return services.getAllPatient();  
	}  

	
	@ApiOperation(value="Getting patient details based on Id")
	@GetMapping("/getpatient/{id}")  
	public PatientDto getPatient(@PathVariable int id)   
	{  	Patient patient=services.getPatientById(id);
		/// Patient to PatientDto
		PatientDto p=PatientMapper.instance.toPatientDto(patient);
		return p;  
	}
	
	
	//@RequestMapping(value = "patient/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Adding patient details")
	@PostMapping("/addpatient")
	public ResponseEntity<String> savePatient(@RequestBody PatientDto patientDto)   
	{  
		//PatientDto to Patiet
		Patient patient=PatientMapper.instance.toPatient(patientDto);
		
		ResponseEntity<String> response=null;
		Integer id=services.savePatient(patient);
		String msg="Patient with "+id+" is saved";
		response=new ResponseEntity<String>(msg,HttpStatus.OK);
		return response;
	}
	
	
	
	@ApiOperation(value="For Deleting patient details")
	@DeleteMapping("/delete/{id}")
	public List<Patient> delete(@PathVariable int id){
		return services.removePatient(id);
	}
	
	
	@PutMapping("/addpatient/{id}")
	public ResponseEntity<String> update(@RequestBody Patient patient,@PathVariable int id) {
		ResponseEntity<String> response=null;
		id=services.update(patient, id); 
		String msg="Patient with "+id+" is saved";
		response=new ResponseEntity<String>(msg,HttpStatus.OK);
		return response;
	  }
	
	
	@ApiOperation(value="Description")
	@GetMapping("/description")
	public String description() {
		return "This Application is made for storing Patients Details";
	}
}
