package com.hotmarzz.oa.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class EmpDto {

	private Long empId;
	@NotEmpty(message="旧密码不能为空")
	private String oldPwd;
	@NotEmpty(message="新密码不能为空")
	private String newPwd;
	@NotEmpty(message="检验新密码不能为空")
	private String ckNewPwd;
	
	
	@Override
	public String toString() {
		return "EmpDto [empId=" + empId + ", oldPwd=" + oldPwd + ", newPwd="
				+ newPwd + ", ckNewPwd=" + ckNewPwd + "]";
	}

	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getOldPwd() {
		return oldPwd;
	}
	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	public String getCkNewPwd() {
		return ckNewPwd;
	}
	public void setCkNewPwd(String ckNewPwd) {
		this.ckNewPwd = ckNewPwd;
	}
	
}
