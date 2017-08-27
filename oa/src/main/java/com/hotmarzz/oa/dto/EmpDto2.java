package com.hotmarzz.oa.dto;

public class EmpDto2 {

	private long empid;
	private String empname;
	public long getEmpid() {
		return empid;
	}
	public void setEmpid(long empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	@Override
	public String toString() {
		return "EmpDto2 [empid=" + empid + ", empname=" + empname + "]";
	}
	
}
