package com.plasmit.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.plasmit.hospital.dao.PatientDao;
import com.plasmit.hospital.entities.Patient;

@Service
public class PatientService 
{
	@Autowired
	PatientDao patientDao;
	
	public Patient addpatient(Patient patient)
	{
		return patientDao.addPatient(patient); 
	}

	public Patient updatePatient(Patient patient)
	{
		return patientDao.updatePatient(patient);
	}
	
	public Patient getById(int id)
	{
		return patientDao.getById(id);
	}
	public String deleteById(int id)
	{
		return patientDao.deleteById(id);
	}
	
	public List <Patient> getAll(Patient patient)
	{
		return patientDao.allDetails();
	}
	public List<Patient> getByState(String state)
	{
		return patientDao.getState(state);
	}
	public List<Patient> getByDistrict(String city)
	{
		return patientDao.getCity(city);
	}
	public List<Patient> getbyCountry(String country)
	{
		return patientDao.getCountry(country);
	}
	public List<Patient> getByPname(String pname)
	{
		return patientDao.getPatientByName(pname);
	}
	public Boolean isIdExist(int id)
	{
		return patientDao.isExist(id);
	}
	public Boolean isStateExist(String state)
	{
		return patientDao.isStateExist(state);
	}
	public Boolean isDistrictExist(String district)
	{
		return patientDao.isCityExist(district);
	}
	public Boolean isCountryExist(String country)
	{
		return patientDao.isCountryExist(country);
	}
	public Boolean isPatientExist(String pname)
	{
		return patientDao.isPatientExist(pname);
	}
}
