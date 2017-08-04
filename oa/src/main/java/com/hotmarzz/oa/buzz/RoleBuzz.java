package com.hotmarzz.oa.buzz;

import java.util.List;

import com.hotmarzz.basic.dao.BaseQuery;
import com.hotmarzz.oa.pojo.Role;

public interface RoleBuzz {
	void add(Role role) throws Exception;
	void update(Role role) throws Exception;
	Role getById(Long roleId) throws Exception;
	BaseQuery getList(BaseQuery bq) throws Exception;
	List<Role> getAll() throws Exception;
	void delete(Long roleId) throws Exception;
}
