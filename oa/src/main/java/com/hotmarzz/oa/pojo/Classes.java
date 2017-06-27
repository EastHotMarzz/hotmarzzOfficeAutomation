package com.hotmarzz.oa.pojo;

import java.util.Date;

public class Classes {
	private Long classId;
	private String className;
	private String PREDIRECTION;
	private ClassStatus classStatus;
	public enum ClassStatus{
		notStart,audition,start,end
	}
	private Date openTime;
	private Date endTime;
	private String lector;
	private String tutor;
	private Integer originalStuAmount;
	private Integer currentStuAmount;
	private String createUser;
	private Date createDate;
	private String updateUser;
	private Date updateDate;
	public Long getClassId() {
		return classId;
	}
	public void setClassId(Long classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getPREDIRECTION() {
		return PREDIRECTION;
	}
	public void setPREDIRECTION(String pREDIRECTION) {
		PREDIRECTION = pREDIRECTION;
	}
	public ClassStatus getClassStatus() {
		return classStatus;
	}
	public void setClassStatus(ClassStatus classStatus) {
		this.classStatus = classStatus;
	}
	public Date getOpenTime() {
		return openTime;
	}
	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getLector() {
		return lector;
	}
	public void setLector(String lector) {
		this.lector = lector;
	}
	public String getTutor() {
		return tutor;
	}
	public void setTutor(String tutor) {
		this.tutor = tutor;
	}
	public Integer getOriginalStuAmount() {
		return originalStuAmount;
	}
	public void setOriginalStuAmount(Integer originalStuAmount) {
		this.originalStuAmount = originalStuAmount;
	}
	public Integer getCurrentStuAmount() {
		return currentStuAmount;
	}
	public void setCurrentStuAmount(Integer currentStuAmount) {
		this.currentStuAmount = currentStuAmount;
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
