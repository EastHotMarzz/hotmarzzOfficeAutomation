package com.hotmarzz.oa.buzz;

import java.util.List;

import com.hotmarzz.basic.dao.BaseQuery;
import com.hotmarzz.oa.pojo.SchoolDistrict;

public interface SchoolBuzz {

	BaseQuery getList(BaseQuery bq) throws Exception;
	//新增校区
	void add(SchoolDistrict sd) throws Exception;
	//根据id查询校区信息
	SchoolDistrict getById(Long schoolId) throws Exception;
	//修改校区信息
	void update(SchoolDistrict sd) throws Exception;
	//删除校区
	void delete(Long schoolId) throws Exception;
	//查询所有校区
	List<SchoolDistrict> getAll() throws Exception;
}
