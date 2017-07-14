package com.hotmarzz.oa.pojo;

import java.util.Date;

public class FinSubjectDetail {

	private Long finSubDetailId;
	private String finSubDetailName;
	private FinSubject finSubjectId;
	private Long finSubjectIdDto;
	private String createUser;
	private Date createDate;
	private String updateUser;
	private Date updateDate;
	public Long getFinSubDetailId() {
		return finSubDetailId;
	}
	public void setFinSubDetailId(Long finSubDetailId) {
		this.finSubDetailId = finSubDetailId;
	}
	public String getFinSubDetailName() {
		return finSubDetailName;
	}
	public void setFinSubDetailName(String finSubDetailName) {
		this.finSubDetailName = finSubDetailName;
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
		return "FinSubjectDetail [finSubDetailId=" + finSubDetailId
				+ ", finSubDetailName=" + finSubDetailName + ", finSubjectId="
				+ finSubjectId + ", finSubjectIdDto=" + finSubjectIdDto
				+ ", createUser=" + createUser + ", createDate=" + createDate
				+ ", updateUser=" + updateUser + ", updateDate=" + updateDate
				+ "]";
	}
}
