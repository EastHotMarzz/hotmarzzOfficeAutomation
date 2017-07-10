package com.hotmarzz.oa.pojo;

import java.util.Date;

public class CampusWater {

	private Long waterId;
	private Long schoolId;
	private Long subjectId;
	private Long subjectDetailId;
	private int waterType;
	private String waterBanch;
	private Double waterSum;
	private String remark;
	private Date waterDate;
	private String billPath;
	private String brokerage;
	private String createUser;
	private Date createDate;
	private String updateUser;
	private Date updateDate;
	public Long getWaterId() {
		return waterId;
	}
	public void setWaterId(Long waterId) {
		this.waterId = waterId;
	}
	public Long getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}
	public Long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}
	public Long getSubjectDetailId() {
		return subjectDetailId;
	}
	public void setSubjectDetailId(Long subjectDetailId) {
		this.subjectDetailId = subjectDetailId;
	}
	public int getWaterType() {
		return waterType;
	}
	public void setWaterType(int waterType) {
		this.waterType = waterType;
	}
	public String getWaterBanch() {
		return waterBanch;
	}
	public void setWaterBanch(String waterBanch) {
		this.waterBanch = waterBanch;
	}
	public Double getWaterSum() {
		return waterSum;
	}
	public void setWaterSum(Double waterSum) {
		this.waterSum = waterSum;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getWaterDate() {
		return waterDate;
	}
	public void setWaterDate(Date waterDate) {
		this.waterDate = waterDate;
	}
	public String getBillPath() {
		return billPath;
	}
	public void setBillPath(String billPath) {
		this.billPath = billPath;
	}
	public String getBrokerage() {
		return brokerage;
	}
	public void setBrokerage(String brokerage) {
		this.brokerage = brokerage;
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
	@Override
	public String toString() {
		return "CampusWater [waterId=" + waterId + ", schoolId=" + schoolId
				+ ", subjectId=" + subjectId + ", subjectDetailId="
				+ subjectDetailId + ", waterType=" + waterType
				+ ", waterBanch=" + waterBanch + ", waterSum=" + waterSum
				+ ", remark=" + remark + ", waterDate=" + waterDate
				+ ", billPath=" + billPath + ", brokerage=" + brokerage
				+ ", createUser=" + createUser + ", createDate=" + createDate
				+ ", updateUser=" + updateUser + ", updateDate=" + updateDate
				+ "]";
	}
}
