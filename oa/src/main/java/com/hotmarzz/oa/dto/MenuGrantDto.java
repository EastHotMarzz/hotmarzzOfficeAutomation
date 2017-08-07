package com.hotmarzz.oa.dto;

import java.util.List;

import com.hotmarzz.oa.pojo.Resource;
import com.hotmarzz.oa.pojo.Role;

public class MenuGrantDto implements Comparable<MenuGrantDto>{
	private Long roleId;
	private Long[] resourceIds;
	private Role role;
	private List<Resource> resources;
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long[] getResourceIds() {
		return resourceIds;
	}
	public void setResourceIds(Long[] resourceIds) {
		this.resourceIds = resourceIds;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public List<Resource> getResources() {
		return resources;
	}
	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}
	@Override
	public int compareTo(MenuGrantDto o) {
		if(o!=null&&o.getRole()!=null&&this.role!=null){
			return (int) (role.getRoleId() - o.getRole().getRoleId());
		}
		return 0;
	}
}
