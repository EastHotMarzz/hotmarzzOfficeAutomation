package com.hotmarzz.oa.pojo;

import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Emp {
	private Long empId;
	@NotEmpty(message="员工姓名不能为空")
	private String empName;
	@NotEmpty(message="用户名不能为空")
	private String userName;
	private String userPwd;
	@NotEmpty(message="电话不能为空")
	private String phone;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hiredate;
	private SchoolDistrict schoolDistrict;
	private Dept dept;
	private Station station;
	private Integer assoWeChat = 1;
	private String createUser;
	private Date createDate;
	private String updateUser;
	private Date updateDate;
	private Integer sex;
	
	//权限操作
	//简单期间，集中到Emp中
	private List<Role> roles;
	private Long[] roleIds;
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public SchoolDistrict getSchoolDistrict() {
		return schoolDistrict;
	}
	public void setSchoolDistrict(SchoolDistrict schoolDistrict) {
		this.schoolDistrict = schoolDistrict;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Station getStation() {
		return station;
	}
	public void setStation(Station station) {
		this.station = station;
	}
	public Integer getAssoWeChat() {
		return assoWeChat;
	}
	public void setAssoWeChat(Integer assoWeChat) {
		this.assoWeChat = assoWeChat;
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
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public Long[] getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(Long[] roleIds) {
		this.roleIds = roleIds;
	}
	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", empName=" + empName + ", userName="
				+ userName + ", userPwd=" + userPwd + ", phone=" + phone
				+ ", hiredate=" + hiredate + ", schoolDistrict="
				+ schoolDistrict + ", dept=" + dept + ", station=" + station + ", assoWeChat=" + assoWeChat
				+ ", createUser=" + createUser + ", createDate=" + createDate
				+ ", updateUser=" + updateUser + ", updateDate=" + updateDate
				+ ", sex=" + sex + "]";
	}
	
}
