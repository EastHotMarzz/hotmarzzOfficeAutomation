package com.hotmarzz.oa.pojo;

import java.util.Date;

public class SchoolDistrict {
	//校区id
	private Long schoolId;
	//校区名称
	private String schoolName;
	//所属省份
	private String province;
	//教师数量
	private Integer teacherQuantity;
	//当前开班数
	private Integer currentClassQuantity;
	//当前学员数
	private Integer currentStuQuantity;
	//学生总数
	private Integer totalStuQuantity;
	//创建人
	private String createUser;
	//创建时间
	private Date createDate;
	//修改人
	private String updateUser;
	//修改时间
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
	@Override
	public String toString() {
		return "SchoolDistrict [schoolId=" + schoolId + ", schoolName="
				+ schoolName + ", province=" + province + ", teacherQuantity="
				+ teacherQuantity + ", currentClassQuantity="
				+ currentClassQuantity + ", currentStuQuantity="
				+ currentStuQuantity + ", totalStuQuantity=" + totalStuQuantity
				+ ", createUser=" + createUser + ", createDate=" + createDate
				+ ", updateUser=" + updateUser + ", updateDate=" + updateDate
				+ "]";
	}
}

