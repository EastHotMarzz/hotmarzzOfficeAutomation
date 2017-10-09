package com.hotmarzz.oa.dto;

import com.hotmarzz.oa.pojo.CampusWater;

public class CampusWaterDto extends CampusWater{
	
	public CampusWaterDto(){}
	public CampusWaterDto(CampusWater cw){
		if(cw.getSchoolId()==null){
			this.schoolIdDto=null;
		}else{
			this.schoolIdDto=cw.getSchoolId().getSchoolId();
		}
		if(cw.getSubId()==null){
			this.subIdDto=null;
		}else{
			this.subIdDto=cw.getSubId().getSubjectId();
		}
		if(cw.getSubDetailId()==null){
			this.subDetailIdDto=null;
		}else{
			this.subDetailIdDto=cw.getSubDetailId().getSubjectDetailId();
		}
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
		this.setConditions(cw.getConditions());
		this.setPag(cw.getPag());
		this.setQueryList(cw.getQueryList());
		this.setQueryParams(cw.getQueryParams());
		this.setStartDate(cw.getStartDate());
		this.setEndDate(cw.getEndDate());
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
				+ subIdDto + ", subDetailIdDto=" + subDetailIdDto + " , startDate="+getStartDate()+"]";
	}
	
}
