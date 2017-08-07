package com.hotmarzz.oa.buzz;

import java.util.List;

import com.hotmarzz.oa.dto.ResourceDto;
import com.hotmarzz.oa.pojo.Emp;
import com.hotmarzz.oa.pojo.Resource;
import com.hotmarzz.oa.pojo.RoleResourceLink;

public interface ResourceBuzz {
	List<Resource> getParentMenus() throws Exception;
	List<ResourceDto> getTreeMenus() throws Exception;
	List<ResourceDto> getTreeMenus(List<Resource> menus) throws Exception;
	List<RoleResourceLink> getRoleMenuList() throws Exception;
}
