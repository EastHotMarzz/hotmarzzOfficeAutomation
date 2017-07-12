package com.hotmarzz.oa.pojo;

import java.util.Date;

public class SubjectDetail {

	private Long subjectDetailId;
	private String subjectDetailName;
	private Subject subjectId;
	private String createUser;
	private Date createDate;
	private String updateUser;
	private Date updateDate;
	private String detailTitle;
	
	public Long getSubjectDetailId() {
		return subjectDetailId;
	}
	public void setSubjectDetailId(Long subjectDetailId) {
		this.subjectDetailId = subjectDetailId;
	}
	public String getSubjectDetailName() {
		return subjectDetailName;
	}
	public void setSubjectDetailName(String subjectDetailName) {
		this.subjectDetailName = subjectDetailName;
	}
	public Subject getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Subject subjectId) {
		this.subjectId = subjectId;
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
	public String getDetailTitle() {
		return detailTitle;
	}
	public void setDetailTitle(String detailTitle) {
		this.detailTitle = detailTitle;
	}
	@Override
	public String toString() {
		return "SubjectDetail [subjectDetailId=" + subjectDetailId
				+ ", subjectDetailName=" + subjectDetailName + ", subjectId="
				+ subjectId + ", createUser=" + createUser + ", createDate="
				+ createDate + ", updateUser=" + updateUser + ", updateDate="
				+ updateDate + ", detailTitle=" + detailTitle + "]";
	}
	
}
