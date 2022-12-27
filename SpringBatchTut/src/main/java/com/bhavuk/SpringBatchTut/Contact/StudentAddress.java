package com.bhavuk.SpringBatchTut.Contact;

public class StudentAddress {

	private String address_line1;
	private String address_line2;
	private String address_type;
	private String city;
	private String state_cd;
	private int zip_code;
	private String zip_plus_4;
	public StudentAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentAddress(String address_line1, String address_line2, String address_type, String city, String state_cd,
			int zip_code, String zip_plus_4) {
		super();
		this.address_line1 = address_line1;
		this.address_line2 = address_line2;
		this.address_type = address_type;
		this.city = city;
		this.state_cd = state_cd;
		this.zip_code = zip_code;
		this.zip_plus_4 = zip_plus_4;
	}
	public String getAddress_line1() {
		return address_line1;
	}
	public void setAddress_line1(String address_line1) {
		this.address_line1 = address_line1;
	}
	public String getAddress_line2() {
		return address_line2;
	}
	public void setAddress_line2(String address_line2) {
		this.address_line2 = address_line2;
	}
	public String getAddress_type() {
		return address_type;
	}
	public void setAddress_type(String address_type) {
		this.address_type = address_type;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState_cd() {
		return state_cd;
	}
	public void setState_cd(String state_cd) {
		this.state_cd = state_cd;
	}
	public int getZip_code() {
		return zip_code;
	}
	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}
	public String getZip_plus_4() {
		return zip_plus_4;
	}
	public void setZip_plus_4(String zip_plus_4) {
		this.zip_plus_4 = zip_plus_4;
	}
	
	
	
	
}