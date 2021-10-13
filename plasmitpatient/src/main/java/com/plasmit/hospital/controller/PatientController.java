package com.plasmit.hospital.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.plasmit.hospital.entities.Patient;
import com.plasmit.hospital.exception.CountryNotFoundException;
import com.plasmit.hospital.exception.DistrictNotFoundException;
import com.plasmit.hospital.exception.IdAlreadyExistException;
import com.plasmit.hospital.exception.IdNotFoundException;
import com.plasmit.hospital.exception.PatientNotFoundException;
import com.plasmit.hospital.exception.StateNotFoundException;
import com.plasmit.hospital.service.PatientService;


@RestController
public class PatientController 
{
	private static final Logger log = LoggerFactory.getLogger(PatientController.class);
	
	@Autowired
	private PatientService patientService;
	
	@PostMapping("/addPatient")
	public ResponseEntity<Patient> addPatient(@RequestBody Patient patient)
	{
		int pid = patient.getPid();
		Boolean idExist = patientService.isIdExist(pid);
		if(idExist)
		{
			log.error("Id Entered Already Exist Into The Database . Please Enter Another Id");
			throw new IdAlreadyExistException("Id Enterd Alredy Found Into THe Database . Please Enter Another Id");
		}
		else
		{
			log.info("Inserted A Record Successfully Into The Databases ");
			 Patient addpatient = patientService.addpatient(patient);
			 return new ResponseEntity<Patient>(addpatient,HttpStatus.ACCEPTED);
		}
		
	}

	@PutMapping("/updatePatient")
	public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient)
	{
		int pid = patient.getPid();
		Boolean idExist = patientService.isIdExist(pid);
		if(idExist)
		{
			log.info("Updated A Record Successfully Into The Databases ");
			Patient updatePatient = patientService.updatePatient(patient);
			return new ResponseEntity<Patient>(updatePatient,HttpStatus.ACCEPTED);
			
		}
		else
		{
			log.error(pid + " Id Enterned  Not Found Into The Database So Cant Be Updated");
			throw new IdNotFoundException("Id Entered Not Found Into The Database");

		}
	}
		
	
	@GetMapping("/patient/{id}")
	public ResponseEntity<Patient> getById(@PathVariable int id)
	{
		Boolean idExist = patientService.isIdExist(id);
		if(idExist)
		{
			log.info("Displaying Details For Id "+id);
			Patient byId = patientService.getById(id);
			return new ResponseEntity<Patient>(byId,HttpStatus.OK);

		}
		else
		{
			log.error("Id Entered Not Found Into The Database...");
			throw new IdNotFoundException("Id Entered Not Exist Into The Database");
		}
	}
	
	@DeleteMapping("/patient/{id}")
	public ResponseEntity<String> deletePatient(@PathVariable int id)
	{
		Boolean idExist = patientService.isIdExist(id);
		if(idExist)
		{
			log.info("Id "+id+" Deleted From Your Database Successfully ");
			String deleteById = patientService.deleteById(id);
			return new ResponseEntity<String>(deleteById,HttpStatus.OK);
		}
		else
		{
			log.error("Entered Id Not Found Into The Database ");
			throw new IdNotFoundException("Entered Id Not Found InTo The Database");
		}

	}
	
	@GetMapping("/getAll")
	public List<Patient> getAllDetails(Patient patient) 
	{
		return patientService.getAll(patient);	
	}
	
	@GetMapping("/state/{state}")
	public ResponseEntity<List<Patient>> getByState(@PathVariable String state)
	{
		Boolean stateExist = patientService.isStateExist(state);
		if(stateExist)
		{
			log.info("Getting All Details Whose State Is " + state);
			List<Patient> byState = patientService.getByState(state);
			return new ResponseEntity<List<Patient>>(byState,HttpStatus.ACCEPTED);
		}
		else
		{
			log.error("Entered State "+state+" Not Found In Database .Please Enter Proper State ");
			throw new StateNotFoundException("State Not Found...");
			
		}
		
	}
	
	@GetMapping("/district/{district}")
	public ResponseEntity<List<Patient>> getByDistrict(@PathVariable String district)
	{
		Boolean districtExist = patientService.isDistrictExist(district);
		if(districtExist)
		{
			log.info("Getting All Details Whose Disttrict Is "+district);
			List<Patient> byDistrict = patientService.getByDistrict(district);
			return new ResponseEntity<List<Patient>>(byDistrict,HttpStatus.OK);
		}
		else
		{
			log.error("Entered District "+district+" Not Found In The Database");
			throw new DistrictNotFoundException("District Not Found...");
		}
	
	}
	@GetMapping("/country/{country}")
	public ResponseEntity<List<Patient>> getByCountry(@PathVariable String country)
	{
		Boolean countryExist = patientService.isCountryExist(country);
		if(countryExist)
		{
			log.info("Getting All Details Whose Country Name is "+country);
			List<Patient> getbyCountry = patientService.getbyCountry(country);
			return new ResponseEntity<List<Patient>>(getbyCountry,HttpStatus.OK);
		}
		else
		{
			log.error("Country Entered Not Found Into The Database");
			throw new CountryNotFoundException("Country Not Found Into The Database");
		}
	}
	
	@GetMapping("/patientName/{pname}")
	public ResponseEntity<List<Patient>> getByPatientName(@PathVariable String pname)
	{
		Boolean patientExist = patientService.isPatientExist(pname);
		if(patientExist)
		{
			log.info("Getting All Details Whose Patient Name is "+pname);
			List<Patient> byPname = patientService.getByPname(pname);
			return new ResponseEntity<List<Patient>>(byPname,HttpStatus.OK);
		}
		else
		{
			log.error("Patient Name "+pname +" Enetered Not Found In Database ");
			throw new PatientNotFoundException("Entered Patient Not Found In The Database ");
			
		}
		
		
	}
	
	
}
