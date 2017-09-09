package com.hotmarzz.oa.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Financial {
	private Long finappId;
	private Double finappSum;
	private String finappDes;
	private FinSubject finSubjectId;
	private Long finSubjectIdDto;
	private FinSubjectDetail finSubDetId;
	private Long finSubDetIdDto;
	private String applyUser;
	private String approveUser;
	private String approveView;
	private String appropriationUser;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date appropriationTime;
	private String finStatus;
	private String createUser;
	private Date createDate;
	private String updateUser;
	private Date updateDate;
	//添加校区名属性
	private String schoolName;
	
	
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public Long getFinappId() {
		return finappId;
	}
	public void setFinappId(Long finappId) {
		this.finappId = finappId;
	}
	public Double getFinappSum() {
		return finappSum;
	}
	public void setFinappSum(Double finappSum) {
		this.finappSum = finappSum;
	}
	public String getFinappDes() {
		return finappDes;
	}
	public void setFinappDes(String finappDes) {
		this.finappDes = finappDes;
	}
	public FinSubject getFinSubjectId() {
		return finSubjectId;
	}
	public void setFinSubjectId(FinSubject finSubjectId) {
		this.finSubjectId = finSubjectId;
	}
	public Long getFinSubjectIdDto() {
		return finSubjectIdDto;
	}
	public void setFinSubjectIdDto(Long finSubjectIdDto) {
		this.finSubjectIdDto = finSubjectIdDto;
	}
	public FinSubjectDetail getFinSubDetId() {
		return finSubDetId;
	}
	public void setFinSubDetId(FinSubjectDetail finSubDetId) {
		this.finSubDetId = finSubDetId;
	}
	public Long getFinSubDetIdDto() {
		return finSubDetIdDto;
	}
	public void setFinSubDetIdDto(Long finSubDetIdDto) {
		this.finSubDetIdDto = finSubDetIdDto;
	}
	public String getApplyUser() {
		return applyUser;
	}
	public void setApplyUser(String applyUser) {
		this.applyUser = applyUser;
	}
	public String getApproveUser() {
		return approveUser;
	}
	public void setApproveUser(String approveUser) {
		this.approveUser = approveUser;
	}
	public String getApproveView() {
		return approveView;
	}
	public void setApproveView(String approveView) {
		this.approveView = approveView;
	}
	public String getAppropriationUser() {
		return appropriationUser;
	}
	public void setAppropriationUser(String appropriationUser) {
		this.appropriationUser = appropriationUser;
	}
	public Date getAppropriationTime() {
		return appropriationTime;
	}
	public void setAppropriationTime(Date appropriationTime) {
		this.appropriationTime = appropriationTime;
	}
	public String getFinStatus() {
		return finStatus;
	}
	public void setFinStatus(String finStatus) {
		this.finStatus = finStatus;
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
		return "Financial [finappId=" + finappId + ", finappSum=" + finappSum
				+ ", finappDes=" + finappDes + ", finSubjectId=" + finSubjectId
				+ ", finSubjectIdDto=" + finSubjectIdDto + ", finSubDetId="
				+ finSubDetId + ", finSubDetIdDto=" + finSubDetIdDto
				+ ", applyUser=" + applyUser + ", approveUser=" + approveUser
				+ ", approveView=" + approveView + ", appropriationUser="
				+ appropriationUser + ", appropriationTime="
				+ appropriationTime + ", finStatus=" + finStatus
				+ ", createUser=" + createUser + ", createDate=" + createDate
				+ ", updateUser=" + updateUser + ", updateDate=" + updateDate
				+ "]";
	}
}
