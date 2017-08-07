package com.hotmarzz.oa.buzz.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotmarzz.basic.dao.BaseQuery;
import com.hotmarzz.oa.buzz.MenuGrantBuzz;
import com.hotmarzz.oa.buzz.RoleBuzz;
import com.hotmarzz.oa.dao.MenuGrantDao;
import com.hotmarzz.oa.dao.RoleDao;
import com.hotmarzz.oa.pojo.Role;

@Service
public class RoleBuzzImpl implements RoleBuzz {
	
	private RoleDao roleDao;
	
	private MenuGrantBuzz menuGrantBuzz;
	
	public RoleDao getRoleDao() {
		return roleDao;
	}
	@Autowired
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	
	public MenuGrantBuzz getMenuGrantBuzz() {
		return menuGrantBuzz;
	}
	@Autowired
	public void setMenuGrantBuzz(MenuGrantBuzz menuGrantBuzz) {
		this.menuGrantBuzz = menuGrantBuzz;
	}
	
	@Override
	@Transactional
	public void add(Role role) throws Exception {
		roleDao.insert(role);
	}
	@Override
	@Transactional
	public void update(Role role) throws Exception {
		roleDao.update(role);
	}
	@Override
	@Transactional
	public Role getById(Long roleId) throws Exception {
		return roleDao.getById(roleId);
	}
	@Override
	@Transactional
	public BaseQuery getList(BaseQuery bq) throws Exception {
		List<Role> roles = roleDao.getListPage(bq);
		int count = roleDao.getCount(bq);
		bq.getPag().setTotal_count(count);
		bq.getPag().setPageList(roles);
		return bq;
	}
	@Override
	@Transactional
	public void delete(Long roleId) throws Exception {
		menuGrantBuzz.deleteGrants(roleId);
		roleDao.delete(roleId);
	}
	@Override
	@Transactional
	public List<Role> getAll() throws Exception {
		List<Role> roles = roleDao.getAll();
		Collections.sort(roles);
		return roles;
	}

}
