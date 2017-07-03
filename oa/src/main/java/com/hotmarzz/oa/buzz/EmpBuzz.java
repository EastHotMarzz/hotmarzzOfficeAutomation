package com.hotmarzz.oa.buzz;

import com.hotmarzz.basic.dao.BaseQuery;
import com.hotmarzz.oa.pojo.Emp;

public interface EmpBuzz {
	/**
	 * 添加员工信息
	 * @param emp
	 * @throws Exception
	 */
	void add(Emp emp) throws Exception;
	/**
	 * 修改员工数据
	 * @param emp
	 * @throws Exception
	 */
	void update(Emp emp) throws Exception;
	/**
	 * 根据ID修改员工数据
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Emp getById(Long id) throws Exception;

	BaseQuery getList(BaseQuery bq) throws Exception;
	/**
	 * 删除员工
	 * @param empId 
	 * @throws Exception
	 */
	void delete(Long empId) throws Exception;
	/**
	 * 登陆
	 * @param emp
	 * @return
	 * @throws Exception
	 */
	Emp login(Emp emp) throws Exception;
	/**
	 * 检测老密码
	 * @param emp
	 * @return
	 * @throws Exception
	 */
	Emp ckOldPwd(Emp emp) throws Exception;
	
	/**
	 * 修改密码
	 * @param emp
	 * @return
	 * @throws Exception
	 */
	void updatePwd(Emp emp) throws Exception;
}
