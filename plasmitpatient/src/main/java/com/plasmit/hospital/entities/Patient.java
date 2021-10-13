package com.plasmit.hospital.entities;

import org.springframework.data.annotation.Id;

public class Patient {

	@Id
	private int pid;
	private String patientName;
	private String wardNo;
	private int bedNo;
	private int totalDays;
	private int totalBill;
	private String country;
	private String state;
	private String district;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getWardNo() {
		return wardNo;
	}

	public void setWardNo(String wardNo) {
		this.wardNo = wardNo;
	}

	public int getBedNo() {
		return bedNo;
	}

	public void setBedNo(int bedNo) {
		this.bedNo = bedNo;
	}

	public int getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(int totalDays) {
		this.totalDays = totalDays;
	}

	public int getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(int totalBill) {
		this.totalBill = totalBill;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(int pid, String patientName, String wardNo, int bedNo, int totalDays, int totalBill, String country,
			String state, String district) {
		super();
		this.pid = pid;
		this.patientName = patientName;
		this.wardNo = wardNo;
		this.bedNo = bedNo;
		this.totalDays = totalDays;
		this.totalBill = totalBill;
		this.country = country;
		this.state = state;
		this.district = district;
	}

}
