package com.hotmarzz.oa.pojo;

import java.util.Date;

public class SchoolDistrict {
	private Long schoolId;
	private String schoolName;
	private String province;
	private Integer teacherQuantity;
	private Integer currentClassQuantity;
	private Integer currentStuQuantity;
	private Integer totalStuQuantity;
	private String createUser;
	private Date createDate;
	private String updateUser;
	private Date updateDate;
	public Long getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public Integer getTeacherQuantity() {
		return teacherQuantity;
	}
	public void setTeacherQuantity(Integer teacherQuantity) {
		this.teacherQuantity = teacherQuantity;
	}
	public Integer getCurrentClassQuantity() {
		return currentClassQuantity;
	}
	public void setCurrentClassQuantity(Integer currentClassQuantity) {
		this.currentClassQuantity = currentClassQuantity;
	}
	public Integer getCurrentStuQuantity() {
		return currentStuQuantity;
	}
	public void setCurrentStuQuantity(Integer currentStuQuantity) {
		this.currentStuQuantity = currentStuQuantity;
	}
	public Integer getTotalStuQuantity() {
		return totalStuQuantity;
	}
	public void setTotalStuQuantity(Integer totalStuQuantity) {
		this.totalStuQuantity = totalStuQuantity;
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
