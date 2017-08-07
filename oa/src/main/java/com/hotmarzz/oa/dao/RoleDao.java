package com.hotmarzz.oa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hotmarzz.basic.dao.BaseQuery;
import com.hotmarzz.oa.pojo.Role;

@Repository
public interface RoleDao {
	void insert(Role role) throws Exception;
	void update(Role role) throws Exception;
	void delete(Long roleId) throws Exception;
	Role getById(Long roleId) throws Exception;
	List<Role> getListPage(BaseQuery bq) throws Exception;
	List<Role> getAll() throws Exception;
	int getCount(BaseQuery bq) throws Exception;
}
