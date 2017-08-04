package com.hotmarzz.oa.buzz.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotmarzz.basic.dao.BaseQuery;
import com.hotmarzz.oa.buzz.MenuGrantBuzz;
import com.hotmarzz.oa.dao.MenuGrantDao;
import com.hotmarzz.oa.dto.MenuGrantDto;
import com.hotmarzz.oa.pojo.MenuGrant;
import com.hotmarzz.oa.pojo.Resource;
import com.hotmarzz.oa.pojo.Role;

@Service
public class MenuGrantBuzzImpl implements MenuGrantBuzz {
	
	private MenuGrantDao menuDrantDao;
	
	public MenuGrantDao getMenuDrantDao() {
		return menuDrantDao;
	}
	@Autowired
	public void setMenuDrantDao(MenuGrantDao menuDrantDao) {
		this.menuDrantDao = menuDrantDao;
	}

	@Override
	@Transactional
	public BaseQuery getList(BaseQuery bq) throws Exception {
		List<MenuGrant> menuGrants = menuDrantDao.getAll(bq);
		List<MenuGrantDto> menuGrantDtos = new ArrayList<MenuGrantDto>();
		Map<Role,List<Resource>> map = new HashMap<Role,List<Resource>>();
		if(menuGrants!=null&&menuGrants.size()>0){
			for(MenuGrant menuGrant:menuGrants){
				if(map.containsKey(menuGrant.getRole())){
					map.get(menuGrant.getRole()).add(menuGrant.getResource());
				}else{
					List<Resource> res = new ArrayList<Resource>();
					res.add(menuGrant.getResource());
					map.put(menuGrant.getRole(), res);
				}
			}
		}
		if(map!=null&&map.size()>0){
			for(Role role:map.keySet()){
				MenuGrantDto dto = new MenuGrantDto();
				dto.setRole(role);
				dto.setResources(map.get(role));
				menuGrantDtos.add(dto);
			}
		}
		Collections.sort(menuGrantDtos);
		bq.getPag().setTotal_count(menuGrantDtos.size());
		bq.getPag().setPageList(menuGrantDtos);
		return bq;
	}
	
	@Override
	@Transactional
	public List<Resource> getMenusByRole(Long roleId) throws Exception {
		return menuDrantDao.getMenusByRole(roleId);
	}
	
	@Override
	@Transactional
	public void addOrUpdate(MenuGrantDto menuGrantDto) throws Exception {
		deleteGrants(menuGrantDto);
		for(Long resourceId:menuGrantDto.getResourceIds()){
			MenuGrant menuGrant = new MenuGrant();
			Role role = new Role();
			Resource menu = new Resource();
			role.setRoleId(menuGrantDto.getRoleId());
			menu.setResourceId(resourceId);
			menuGrant.setRole(role);
			menuGrant.setResource(menu);
			addOnce(menuGrant);
		}
	}
	
	@Override
	@Transactional
	public void deleteGrants(MenuGrantDto menuGrantDto) throws Exception {
		menuDrantDao.deleteByRole(menuGrantDto.getRoleId());
	}
	
	@Override
	@Transactional
	public void addOnce(MenuGrant menuGrant) throws Exception {
		menuDrantDao.insert(menuGrant);
	}
	@Override
	@Transactional
	public void deleteGrants(Long roleId) throws Exception {
		menuDrantDao.deleteByRole(roleId);
	}
	
	
	
	
}
