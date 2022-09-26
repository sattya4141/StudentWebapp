package com.java.restapi.bean;

public class StdBean {
	
	private int stdId;
	private String stdName;
	private double stdFees;
	private String stdEmail;
	private String stdAddress;
	public StdBean(int stdId, String stdName, double stdFees, String stdEmail, String stdAddress) {
		super();
		this.stdId = stdId;
		this.stdName = stdName;
		this.stdFees = stdFees;
		this.stdEmail = stdEmail;
		this.stdAddress = stdAddress;
	}
	@Override
	public String toString() {
		return "StdBean [stdId=" + stdId + ", stdName=" + stdName + ", stdFees=" + stdFees + ", stdEmail=" + stdEmail
				+ ", stdAddress=" + stdAddress + "]";
	}
	public StdBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getStdId() {
		return stdId;
	}
	public void setStdId(int stdId) {
		this.stdId = stdId;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public double getStdFees() {
		return stdFees;
	}
	public void setStdFees(double stdFees) {
		this.stdFees = stdFees;
	}
	public String getStdEmail() {
		return stdEmail;
	}
	public void setStdEmail(String stdEmail) {
		this.stdEmail = stdEmail;
	}
	public String getStdAddress() {
		return stdAddress;
	}
	public void setStdAddress(String stdAddress) {
		this.stdAddress = stdAddress;
	}

}
