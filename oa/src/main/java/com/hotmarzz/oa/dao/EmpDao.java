package com.hotmarzz.oa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hotmarzz.basic.dao.BaseQuery;
import com.hotmarzz.oa.pojo.Emp;

@Repository
public interface EmpDao {
	void insert(Emp emp) throws Exception;
	void update(Emp emp) throws Exception;
	void delete(String empId) throws Exception;
	Emp getById(String empId) throws Exception;
	Emp chkLogin(Emp emp) throws Exception;
	List<Emp> getListPage(BaseQuery bq);
	int getCount(BaseQuery bq);
}
