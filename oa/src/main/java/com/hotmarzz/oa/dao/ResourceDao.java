package com.hotmarzz.oa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hotmarzz.oa.pojo.Resource;
import com.hotmarzz.oa.pojo.RoleResourceLink;

@Repository
public interface ResourceDao {
	Resource getMenuById(Long resourceId) throws Exception;
	Resource getParentMenuById(Long resourceId) throws Exception;
	List<Resource> getParentMenus() throws Exception;
	//获得角色和菜单的映射
	List<RoleResourceLink> getRoleMenuList() throws Exception;
}
