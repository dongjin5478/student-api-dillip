package com.student.request;

public class WeightSlipRequest {
	private String address;
	private String vehicleNumber;
	private String grossWeight;
	private String tareWeight;
	private String grossWeightDate;
	private String tareWeightDate;
	private String grossWeightTime;
	private String tareWeightTime;
	private String message;
	
	public WeightSlipRequest() {
		super();
		this.message = "Thank You ! Visit Again";
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getGrossWeight() {
		return grossWeight;
	}
	public void setGrossWeight(String grossWeight) {
		this.grossWeight = grossWeight;
	}
	public String getTareWeight() {
		return tareWeight;
	}
	public void setTareWeight(String tareWeight) {
		this.tareWeight = tareWeight;
	}
	public String getGrossWeightDate() {
		return grossWeightDate;
	}
	public void setGrossWeightDate(String grossWeightDate) {
		this.grossWeightDate = grossWeightDate;
	}
	public String getTareWeightDate() {
		return tareWeightDate;
	}
	public void setTareWeightDate(String tareWeightDate) {
		this.tareWeightDate = tareWeightDate;
	}
	public String getGrossWeightTime() {
		return grossWeightTime;
	}
	public void setGrossWeightTime(String grossWeightTime) {
		this.grossWeightTime = grossWeightTime;
	}
	public String getTareWeightTime() {
		return tareWeightTime;
	}
	public void setTareWeightTime(String tareWeightTime) {
		this.tareWeightTime = tareWeightTime;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}	
}
