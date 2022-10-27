package com.tcs.springboot.patientservice;

import java.util.List;

import com.tcs.springboot.patientmodel.Patient;

public interface Services {
	public List<Patient> getAllPatient();
	public Patient getPatientById(int id);
	public Integer savePatient(Patient patient);
	public List<Patient> removePatient(int id);
	public Integer update(Patient patient,int id);
}
