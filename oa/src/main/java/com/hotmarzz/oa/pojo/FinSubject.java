package com.hotmarzz.oa.pojo;

import java.util.Date;

public class FinSubject {

	private Long finSubjectId;
	private String finSubjectName;
	private String createUser;
	private Date createDate;
	private String updateUser;
	private Date updateDate;
	
	public Long getFinSubjectId() {
		return finSubjectId;
	}
	public void setFinSubjectId(Long finSubjectId) {
		this.finSubjectId = finSubjectId;
	}
	public String getFinSubjectName() {
		return finSubjectName;
	}
	public void setFinSubjectName(String finSubjectName) {
		this.finSubjectName = finSubjectName;
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
		return "FinSubject [finSubjectId=" + finSubjectId + ", finSubjectName="
				+ finSubjectName + ", createUser=" + createUser
				+ ", createDate=" + createDate + ", updateUser=" + updateUser
				+ ", updateDate=" + updateDate + "]";
	}
	
}
