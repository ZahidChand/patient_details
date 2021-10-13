package com.plasmit.hospital.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.plasmit.hospital.entities.Patient;

@Repository
public class PatientDaoImpl implements PatientDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public PatientDaoImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Patient addPatient(Patient patient) {

		String sql = "insert into patientdetails values(?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, patient.getPid(), patient.getPatientName(), patient.getWardNo(), patient.getBedNo(),
				patient.getTotalDays(), patient.getTotalBill(), patient.getCountry(), patient.getState(),
				patient.getDistrict());

		return patient;

	}
	
	@Override
	public Patient updatePatient(Patient patient) {
		String sql = "update patientdetails set pname = ?,wardno = ?,bedno = ?,totaldays = ?,totalbill = ?,country = ? ,state = ?,district = ? where pid =?";
		jdbcTemplate.update(sql, patient.getPatientName(), patient.getWardNo(), patient.getBedNo(),
				patient.getTotalDays(), patient.getTotalBill(), patient.getCountry(), patient.getState(),
				patient.getDistrict(), patient.getPid());

		return patient;
	}

	@Override
	public Patient getById(int id) 
	{
		String sql ="select * from patientdetails where pid = ?";
		return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
			return new Patient(
				rs.getInt("pid"),rs.getString("pname"),rs.getString("wardno"),
				rs.getInt("bedno"),rs.getInt("totaldays"),rs.getInt("totalbill"),
				rs.getString("country"),rs.getString("state"),rs.getString("district"));
		},id);
	}

	@Override
	public String deleteById(int id) {
		String sql ="delete from patientdetails where pid =?";
		jdbcTemplate.update(sql,id);
		return "Record Deleted Succefully";

	}

	@Override
	public List<Patient> allDetails() {
		String sql = "select * from patientdetails";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			return new Patient(rs.getInt("pid"), rs.getString("pname"), rs.getString("wardno"), rs.getInt("bedno"),
					rs.getInt("totaldays"), rs.getInt("totalbill"), rs.getString("country"), rs.getString("state"),
					rs.getString("district"));
		});

	}

	@Override
	public List<Patient> getState(String statename) 
	{
		String sql ="select * from patientdetails where state = ?";
		List<Map<String,Object>> list = jdbcTemplate.queryForList(sql,statename);
		
		List<Patient> patientlist = new ArrayList<>();
		
		for(Map<String,Object> map : list)
		{
			Patient patient = new Patient();

			patient.setPid((Integer) map.get("pid"));
			patient.setPatientName((String) map.get("pname"));
			patient.setWardNo((String) map.get("wardno"));
			patient.setBedNo((Integer) map.get("bedno"));
			patient.setTotalDays((Integer) map.get("totaldays"));
			patient.setTotalBill((Integer) map.get("totalbill"));
			patient.setCountry((String) map.get("country"));
			patient.setState((String) map.get("state"));
			patient.setDistrict((String) map.get("district"));
			patientlist.add(patient);
		}
		return patientlist;
	
	}

	@Override
	public List<Patient> getCity(String city) 
	{
		String sql ="select * from patientdetails where district =?";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql,city);
		
		List<Patient> patientlist= new ArrayList<>();
		for(Map<String ,Object> map :list)
		{
			Patient patient = new Patient();

			patient.setPid((Integer) map.get("pid"));
			patient.setPatientName((String) map.get("pname"));
			patient.setWardNo((String) map.get("wardno"));
			patient.setBedNo((Integer) map.get("bedno"));
			patient.setTotalDays((Integer) map.get("totaldays"));
			patient.setTotalBill((Integer) map.get("totalbill"));
			patient.setCountry((String) map.get("country"));
			patient.setState((String) map.get("state"));
			patient.setDistrict((String) map.get("district"));
			patientlist.add(patient);
			
		}
		
		return patientlist;
	}
	
	@Override
	public List<Patient> getCountry(String country) 
	{
		String sql ="select * from patientdetails where country =?";
		List<Map<String,Object>> list = jdbcTemplate.queryForList(sql,country);
		List<Patient> patientlist= new ArrayList<>();
		for(Map<String ,Object> map :list)
		{
			Patient patient = new Patient();

			patient.setPid((Integer) map.get("pid"));
			patient.setPatientName((String) map.get("pname"));
			patient.setWardNo((String) map.get("wardno"));
			patient.setBedNo((Integer) map.get("bedno"));
			patient.setTotalDays((Integer) map.get("totaldays"));
			patient.setTotalBill((Integer) map.get("totalbill"));
			patient.setCountry((String) map.get("country"));
			patient.setState((String) map.get("state"));
			patient.setDistrict((String) map.get("district"));
			patientlist.add(patient);
			
		}
		
		return patientlist;
	}

	@Override
	public List<Patient> getPatientByName(String pname) 
	{
		String sql ="select * from patientdetails where pname =?";
		List<Map<String,Object>> list = jdbcTemplate.queryForList(sql,pname);
		
		List<Patient > patientlist = new ArrayList<>();
		
		for(Map<String, Object> map:list)
		{
			Patient patient = new Patient();
			
			patient.setPid((Integer) map.get("pid"));
			patient.setPatientName((String) map.get("pname"));
			patient.setWardNo((String) map.get("wardno"));
			patient.setBedNo((Integer) map.get("bedno"));
			patient.setTotalDays((Integer)map.get("totaldays"));
			patient.setTotalBill((Integer) map.get("totalbill"));
			patient.setCountry((String) map.get("country"));
			patient.setState((String) map.get("state"));
			patient.setDistrict((String) map.get("district"));
			patientlist.add(patient);
			
			
		}
		return patientlist;
		
	}

	@Override
	public boolean isExist(int id) 
	{
		String sql ="select count(*) from patientdetails where pid = ?";
		Integer count = jdbcTemplate.queryForObject(sql, new Object[] {id},Integer.class);
		
		if(count >= 1)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isStateExist(String state) 
	{
		String sql = "select  count(*) from patientdetails where state =?";
		Integer count = jdbcTemplate.queryForObject(sql, new Object[] {state},Integer.class);
		if(count>=1)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isCityExist(String city) 
	{
		String sql = "select count(*) from patientdetails where district =?";
		Integer count = jdbcTemplate.queryForObject(sql, new Object[] {city} , Integer.class);
		if(count>=1)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isCountryExist(String country) 
	{
		String sql ="Select count(*) from patientdetails where country =?";
		Integer count = jdbcTemplate.queryForObject(sql, new Object[] {country}, Integer.class);
		if (count>=1)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isPatientExist(String pname) 
	{
		String sql = "select count(*) from patientdetails where pname = ?";
		Integer count =jdbcTemplate.queryForObject(sql, new Object [] {pname} , Integer.class);
		 if(count>=1)
		 {
			 return true;
		 }
		return false;
	}

	

	

}
