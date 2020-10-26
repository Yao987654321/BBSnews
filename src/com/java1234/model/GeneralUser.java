package com.java1234.model;

public class GeneralUser {
	private String generalusername;
	private String generaluserpassword;
	private String generaluseremil;
	private String userid;
	
	public GeneralUser(String generalusername,String generaluserpassword,String generaluseremil) {
		super();
		this.generalusername = generalusername;
		this.generaluserpassword = generaluserpassword;
		this.generaluseremil = generaluseremil;
	}
	public GeneralUser() {
		super();
	}
	public String getGeneralusername() {
		return generalusername;
	}
	public void setGeneralusername(String generalusername) {
		this.generalusername = generalusername;
	}
	public String getGeneraluserpassword() {
		return generaluserpassword;
	}
	public void setGeneraluserpassword(String generaluserpassword) {
		this.generaluserpassword = generaluserpassword;
	}
	public String getGeneraluseremil() {
		return generaluseremil;
	}
	public void setGeneraluseremil(String generaluseremil) {
		this.generaluseremil = generaluseremil;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
}
