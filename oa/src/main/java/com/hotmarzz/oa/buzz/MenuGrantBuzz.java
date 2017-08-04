package com.hotmarzz.oa.buzz;

import java.util.List;

import com.hotmarzz.basic.dao.BaseQuery;
import com.hotmarzz.oa.dto.MenuGrantDto;
import com.hotmarzz.oa.pojo.MenuGrant;
import com.hotmarzz.oa.pojo.Resource;

public interface MenuGrantBuzz {
	
	void addOnce(MenuGrant menuGrant) throws Exception;
	void addOrUpdate(MenuGrantDto menuGrantDto) throws Exception;
	void deleteGrants(MenuGrantDto menuGrantDto) throws Exception;
	void deleteGrants(Long roleId) throws Exception;
	BaseQuery getList(BaseQuery bq) throws Exception;
	List<Resource> getMenusByRole(Long roleId) throws Exception;
}
