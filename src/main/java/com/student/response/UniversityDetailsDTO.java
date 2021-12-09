package com.student.response;

public class UniversityDetailsDTO {
	private String countryName;
	private String countryCode;
	private String universityName;
	private String universityWebsite;
	public UniversityDetailsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UniversityDetailsDTO(String countryName, String countryCode, String universityName,
			String universityWebsite) {
		super();
		this.countryName = countryName;
		this.countryCode = countryCode;
		this.universityName = universityName;
		this.universityWebsite = universityWebsite;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public String getUniversityWebsite() {
		return universityWebsite;
	}
	public void setUniversityWebsite(String universityWebsite) {
		this.universityWebsite = universityWebsite;
	}
	
	
}
