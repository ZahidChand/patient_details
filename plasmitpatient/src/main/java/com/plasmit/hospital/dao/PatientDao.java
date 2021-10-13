package com.plasmit.hospital.dao;

import java.util.List;

import com.plasmit.hospital.entities.Patient;

public interface PatientDao {
	Patient addPatient(Patient patient);

	Patient updatePatient(Patient patient);

	Patient getById(int id);

	String deleteById(int id);

	List<Patient> allDetails();
	
	List <Patient> getState(String statename);

	List <Patient> getCity(String city);	
	
	List <Patient> getCountry(String country);
	
	List<Patient> getPatientByName(String pname);
	
	public boolean isExist(int id);  
	
	public boolean isStateExist(String state);
	
	public boolean isCityExist(String city);
	
	public boolean isCountryExist(String country);
	
	public boolean isPatientExist(String pname);
	
}
