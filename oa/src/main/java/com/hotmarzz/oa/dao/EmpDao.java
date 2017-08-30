package com.hotmarzz.oa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hotmarzz.basic.dao.BaseQuery;
import com.hotmarzz.oa.pojo.Emp;
import com.hotmarzz.oa.pojo.EmpRoleLink;
import com.hotmarzz.oa.pojo.Role;
import com.hotmarzz.oa.pojo.SchoolDistrict;

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
	
	Emp ckOldPwd(Emp emp) throws Exception;
	
	void updatePwd(Emp emp) throws Exception;
	
	List<Role> getRolesByEmp(Long empId) throws Exception;

	void insertEmpRoleLink(EmpRoleLink empRoleLink) throws Exception;
	
	//删除EmpRoleLinke
	void deleteERLByEmp(Long empId) throws Exception;
	//根据用户ID查询所在校区信息
	SchoolDistrict getSchoolByEmp(Long empid) throws Exception;
}
