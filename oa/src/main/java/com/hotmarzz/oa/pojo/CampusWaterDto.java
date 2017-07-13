package com.hotmarzz.oa.pojo;

public class CampusWaterDto extends CampusWater{
	
	public CampusWaterDto(){}
	public CampusWaterDto(CampusWater cw){
		this.schoolIdDto=cw.getSchoolId().getSchoolId();
		this.subIdDto=cw.getSubId().getSubjectId();
		this.subDetailIdDto=cw.getSubDetailId().getSubjectDetailId();
		this.setBillPath(cw.getBillPath());
		this.setBrokerage(cw.getBrokerage());
		this.setCreateDate(cw.getCreateDate());
		this.setCreateUser(cw.getCreateUser());
		this.setIssupple(cw.getIssupple());
		this.setRemark(cw.getRemark());
		this.setSchoolId(cw.getSchoolId());
		this.setSubDetailId(cw.getSubDetailId());
		this.setUpdateDate(cw.getUpdateDate());
		this.setUpdateUser(cw.getUpdateUser());
		this.setWaterBanch(cw.getWaterBanch());
		this.setWaterDate(cw.getWaterDate());
		this.setWaterId(cw.getWaterId());
		this.setWaterSum(cw.getWaterSum());
		this.setWaterType(cw.getWaterType());
	}

	private Long schoolIdDto;
	private Long subIdDto;
	private Long subDetailIdDto;
	public Long getSchoolIdDto() {
		return schoolIdDto;
	}
	public void setSchoolIdDto(Long schoolIdDto) {
		this.schoolIdDto = schoolIdDto;
	}
	public Long getSubIdDto() {
		return subIdDto;
	}
	public void setSubIdDto(Long subIdDto) {
		this.subIdDto = subIdDto;
	}
	public Long getSubDetailIdDto() {
		return subDetailIdDto;
	}
	public void setSubDetailIdDto(Long subDetailIdDto) {
		this.subDetailIdDto = subDetailIdDto;
	}
	@Override
	public String toString() {
		return "CampusWaterDto [schoolIdDto=" + schoolIdDto + ", subIdDto="
				+ subIdDto + ", subDetailIdDto=" + subDetailIdDto + "]";
	}
	
}
