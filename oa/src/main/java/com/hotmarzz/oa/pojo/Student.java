package com.hotmarzz.oa.pojo;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.EAN;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Student {
	private Long stuId;
	@NotEmpty(message="电话不能为空")
	private String phone;
	@NotEmpty(message="姓名不能为空")
	private String stuName;
	private String idNumber;
	private Integer sex;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date entranceTime;
	private Classes firstClasses;
	private Classes currentClasses;
	private StuStatus stuStatus;
	private Date graduation;
	private String graSchool;
	private String education;
	private String proFession;
	private String wskLevel;
	private String computerSkill;
	private String qq;
	@Email(message="必须是邮箱格式")
	private String email;
	private String contactPerson;
	private String remarks;
	private Integer locked;
	private String lockUser;
	private Payment payment;
	private String createUser;
	private Date createDate;
	private String updateUser;
	private Date updateDate;
	@Min(value=16,message="年龄在16~35岁之间")
	@Max(value=35,message="年龄在16~35岁之间")
	private int stuAge;
	
	public int getStuAge() {
		return stuAge;
	}
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}
	private enum StuStatus{
		//试听
		audition,
		//报名
		signUp,
		//就读
		attend,
		//就业
		obtain,
		//流失
		wastage,
		//离校
		leave,
		//结业
		complete
	}
	public Long getStuId() {
		return stuId;
	}
	public void setStuId(Long stuId) {
		this.stuId = stuId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Date getEntranceTime() {
		return entranceTime;
	}
	public void setEntranceTime(Date entranceTime) {
		this.entranceTime = entranceTime;
	}
	public Classes getFirstClasses() {
		return firstClasses;
	}
	public void setFirstClasses(Classes firstClasses) {
		this.firstClasses = firstClasses;
	}
	public Classes getCurrentClasses() {
		return currentClasses;
	}
	public void setCurrentClasses(Classes currentClasses) {
		this.currentClasses = currentClasses;
	}
	public StuStatus getStuStatus() {
		return stuStatus;
	}
	public void setStuStatus(StuStatus stuStatus) {
		this.stuStatus = stuStatus;
	}
	public Date getGraduation() {
		return graduation;
	}
	public void setGraduation(Date graduation) {
		this.graduation = graduation;
	}
	public String getGraSchool() {
		return graSchool;
	}
	public void setGraSchool(String graSchool) {
		this.graSchool = graSchool;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getProFession() {
		return proFession;
	}
	public void setProFession(String proFession) {
		this.proFession = proFession;
	}
	public String getWskLevel() {
		return wskLevel;
	}
	public void setWskLevel(String wskLevel) {
		this.wskLevel = wskLevel;
	}
	public String getComputerSkill() {
		return computerSkill;
	}
	public void setComputerSkill(String computerSkill) {
		this.computerSkill = computerSkill;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getLocked() {
		return locked;
	}
	public void setLocked(Integer locked) {
		this.locked = locked;
	}
	public String getLockUser() {
		return lockUser;
	}
	public void setLockUser(String lockUser) {
		this.lockUser = lockUser;
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
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", phone=" + phone + ", stuName="
				+ stuName + ", idNumber=" + idNumber + ", sex=" + sex
				+ ", entranceTime=" + entranceTime + ", firstClasses="
				+ firstClasses + ", currentClasses=" + currentClasses
				+ ", stuStatus=" + stuStatus + ", graduation=" + graduation
				+ ", graSchool=" + graSchool + ", education=" + education
				+ ", proFession=" + proFession + ", wskLevel=" + wskLevel
				+ ", computerSkill=" + computerSkill + ", qq=" + qq
				+ ", email=" + email + ", contactPerson=" + contactPerson
				+ ", remarks=" + remarks + ", locked=" + locked + ", lockUser="
				+ lockUser + ", payment=" + payment + ", createUser="
				+ createUser + ", createDate=" + createDate + ", updateUser="
				+ updateUser + ", updateDate=" + updateDate + ", stuAge="
				+ stuAge + "]";
	}
	
	
}

