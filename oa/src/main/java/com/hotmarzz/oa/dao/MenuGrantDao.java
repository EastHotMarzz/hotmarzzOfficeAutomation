package com.hotmarzz.oa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hotmarzz.basic.dao.BaseQuery;
import com.hotmarzz.oa.pojo.MenuGrant;
import com.hotmarzz.oa.pojo.Resource;

@Repository
public interface MenuGrantDao {
	void insert(MenuGrant menuGrant) throws Exception;
	void deleteByRole(Long roleId) throws Exception;
	List<MenuGrant> getAll(BaseQuery bq) throws Exception;
	List<Resource> getMenusByRole(Long roleId) throws Exception;
}
