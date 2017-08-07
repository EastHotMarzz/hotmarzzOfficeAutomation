package com.hotmarzz.oa.pojo;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class Role implements Comparable<Role>{
	private Long roleId;
	@NotEmpty(message="角色名不能为空")
	private String roleName;
	private String remark;
	private String createUser;
	private Date createDate;
	private String updateUser;
	private Date updateDate;
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if((obj == null) || (obj.getClass() != this.getClass()))  
			return false;
		if(obj instanceof Role){
			Role r = (Role)obj;
			if(this.roleId.equals(r.getRoleId())){
				return true;
			}
		}
		return false;
	}
	@Override
	public int compareTo(Role o) {
		if(o!=null&&o.getRoleId()!=null){
			return (int) (roleId - o.getRoleId());
		}
		return 0;
	}
	
}
