package com.hotmarzz.oa.pojo;

import java.util.Date;

public class Payment {
	protected Long payId;
	protected PayType payType;
	protected Double tuition;
	protected Student student;
	private String createUser;
	private Date createDate;
	private String updateUser;
	private Date updateDate;
	public enum PayType{
		loan,cash
	}
	public Long getPayId() {
		return payId;
	}
	public void setPayId(Long payId) {
		this.payId = payId;
	}
	public PayType getPayType() {
		return payType;
	}
	public void setPayType(PayType payType) {
		this.payType = payType;
	}
	public Double getTuition() {
		return tuition;
	}
	public void setTuition(Double tuition) {
		this.tuition = tuition;
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
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
}
