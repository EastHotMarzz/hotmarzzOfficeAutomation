package com.hotmarzz.oa.dto;

import java.util.ArrayList;
import java.util.List;

import com.hotmarzz.oa.pojo.Resource;
import com.hotmarzz.oa.pojo.Role;

public class ResourceDto implements Comparable<ResourceDto>{
	private Resource menu;
	private List<Resource> childrenMenus = new ArrayList<Resource>();
	public Resource getMenu() {
		return menu;
	}
	public void setMenu(Resource menu) {
		this.menu = menu;
	}
	public List<Resource> getChildrenMenus() {
		return childrenMenus;
	}
	public void setChildrenMenus(List<Resource> childrenMenus) {
		this.childrenMenus = childrenMenus;
	}
	@Override
	public int compareTo(ResourceDto o) {
		if(this.menu==null||o.getMenu()==null)
			return 1;
		return this.menu.getMenuSort() - o.getMenu().getMenuSort();

	}
}
