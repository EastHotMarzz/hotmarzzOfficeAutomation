package com.hotmarzz.oa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hotmarzz.basic.dao.BaseQuery;
import com.hotmarzz.oa.pojo.Emp;

@Repository
public interface EmpDao {
	
	void insert(Emp emp) throws Exception;

	void update(Emp emp) throws Exception;

	/**
	 * 删除员工信息
	 */
	void delete(Long empId) throws Exception;

	Emp getById(Long empId) throws Exception;

	Emp chkLogin(Emp emp) throws Exception;

	List<Emp> getListPage(BaseQuery bq);

	int getCount(BaseQuery bq);

}
