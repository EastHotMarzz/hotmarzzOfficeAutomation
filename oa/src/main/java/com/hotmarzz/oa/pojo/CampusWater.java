package com.hotmarzz.oa.pojo;

import java.util.Date;

import com.hotmarzz.basic.dao.BaseQuery;

public class CampusWater extends BaseQuery{

	private Long waterId;
	private SchoolDistrict schoolId;
	private Subject subId;
	private SubjectDetail subDetailId;
	private int waterType;
	private String waterBanch;
	private Double waterSum;
	private String remark;
	private Date waterDate;
	//开始日期
	private Date startDate;
	//结束日期
	private Date endDate;
	private String billPath;
	private String brokerage;
	private String createUser;
	private Date createDate;
	private String updateUser;
	private Date updateDate;
	
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Long getWaterId() {
		return waterId;
	}
	public void setWaterId(Long waterId) {
		this.waterId = waterId;
	}
	public SchoolDistrict getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(SchoolDistrict schoolId) {
		this.schoolId = schoolId;
	}
	public Subject getSubId() {
		return subId;
	}
	public void setSubId(Subject subId) {
		this.subId = subId;
	}
	public SubjectDetail getSubDetailId() {
		return subDetailId;
	}
	public void setSubDetailId(SubjectDetail subDetailId) {
		this.subDetailId = subDetailId;
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
				+ ", subId=" + subId + ", subDetailId=" + subDetailId
				+ ", waterType=" + waterType + ", waterBanch=" + waterBanch
				+ ", waterSum=" + waterSum + ", remark=" + remark
				+ ", waterDate=" + waterDate + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", billPath=" + billPath
				+ ", brokerage=" + brokerage + ", createUser=" + createUser
				+ ", createDate=" + createDate + ", updateUser=" + updateUser
				+ ", updateDate=" + updateDate + "]";
	}
}
