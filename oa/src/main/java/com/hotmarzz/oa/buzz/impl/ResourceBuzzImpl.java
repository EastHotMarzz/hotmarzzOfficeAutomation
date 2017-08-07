package com.hotmarzz.oa.buzz.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotmarzz.oa.buzz.ResourceBuzz;
import com.hotmarzz.oa.dao.ResourceDao;
import com.hotmarzz.oa.dto.ResourceDto;
import com.hotmarzz.oa.pojo.Emp;
import com.hotmarzz.oa.pojo.Resource;
import com.hotmarzz.oa.pojo.Role;
import com.hotmarzz.oa.pojo.RoleResourceLink;

@Service
public class ResourceBuzzImpl implements ResourceBuzz {
	
	private ResourceDao resourceDao;
	
	public ResourceDao getResourceDao() {
		return resourceDao;
	}
	@Autowired
	public void setResourceDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}

	@Override
	public List<Resource> getParentMenus() throws Exception {
		return resourceDao.getParentMenus();
	}
	
	@Override
	@Transactional
	public List<ResourceDto> getTreeMenus() throws Exception {
		List<Resource> menus = getParentMenus();
		List<ResourceDto> rds = new ArrayList<ResourceDto>();
		if(menus!=null&&menus.size()>0){
			for(Resource m1:menus){
				if(m1.getMenuLev()==1){
					ResourceDto rd = new ResourceDto();
					rd.setMenu(m1);
					for(Resource m2:menus){
						if(m2.getParentMenu()!=null&&m1.getResourceId().equals(m2.getParentMenu().getResourceId())){
							rd.getChildrenMenus().add(m2);
						}
					}
					rds.add(rd);
				}
			}
		}
		return rds;
	}
	
	@Override
	@Transactional
	public List<ResourceDto> getTreeMenus(List<Resource> menus) throws Exception {
		List<ResourceDto> rds = new ArrayList<ResourceDto>();
		if(menus!=null&&menus.size()>0){
			for(Resource m1:menus){
				if(m1.getMenuLev()==1){
					ResourceDto rd = new ResourceDto();
					rd.setMenu(m1);
					List<Resource> twoMenus = rd.getChildrenMenus();
					for(Resource m2:menus){
						if(m2.getParentMenu()!=null&&m1.getResourceId().equals(m2.getParentMenu().getResourceId())){
							twoMenus.add(m2);
						}
					}
					Collections.sort(twoMenus);
					rds.add(rd);
				}
			}
		}
		Collections.sort(rds);
		return rds;
	}
	@Override
	@Transactional
	public List<RoleResourceLink> getRoleMenuList() throws Exception {
		return resourceDao.getRoleMenuList();
	}
	
}
