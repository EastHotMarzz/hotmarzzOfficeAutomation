package com.hotmarzz.oa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hotmarzz.basic.dao.BaseQuery;
import com.hotmarzz.oa.pojo.Emp;

@Repository
public interface EmpDao {
	/**
	 * 添加员工
	 * @param emp
	 * @throws Exception
	 */
	void insert(Emp emp) throws Exception;
	/**
	 * 修改员工
	 * @param emp
	 * @throws Exception
	 */
	void update(Emp emp) throws Exception;
	/**
	 * 删除员工信息
	 */
	void delete(Long empId) throws Exception;
	/**
	 * 根据ID获取员工
	 * @param empId
	 * @return
	 * @throws Exception
	 */
	Emp getById(Long empId) throws Exception;

	List<Emp> getListPage(BaseQuery bq);

	int getCount(BaseQuery bq);

	Emp login(Emp emp) throws Exception;
	
}
