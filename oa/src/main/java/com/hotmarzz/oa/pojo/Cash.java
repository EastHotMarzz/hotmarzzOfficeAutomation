package com.hotmarzz.oa.pojo;

import java.util.Date;

public class Cash extends Payment{
	private Integer totalPeriod;
	private Integer paidPeriod;
	private Double  paidAmount;
	private Double arrearAmount;
	private String remarks;
	private String createUser;
	private Date createDate;
	private String updateUser;
	private Date updateDate;
	public Integer getTotalPeriod() {
		return totalPeriod;
	}
	public void setTotalPeriod(Integer totalPeriod) {
		this.totalPeriod = totalPeriod;
	}
	public Integer getPaidPeriod() {
		return paidPeriod;
	}
	public void setPaidPeriod(Integer paidPeriod) {
		this.paidPeriod = paidPeriod;
	}
	public Double getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}
	public Double getArrearAmount() {
		return arrearAmount;
	}
	public void setArrearAmount(Double arrearAmount) {
		this.arrearAmount = arrearAmount;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
