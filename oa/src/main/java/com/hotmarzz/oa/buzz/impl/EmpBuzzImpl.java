package com.hotmarzz.oa.buzz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotmarzz.basic.dao.BaseQuery;
import com.hotmarzz.basic.utils.MD5Utils;
import com.hotmarzz.oa.buzz.EmpBuzz;
import com.hotmarzz.oa.dao.EmpDao;
import com.hotmarzz.oa.pojo.Emp;
import com.hotmarzz.oa.utils.Constants;

@Service
public class EmpBuzzImpl implements EmpBuzz {
	
	private EmpDao empDao;
	
	public EmpDao getEmpDao() {
		return empDao;
	}
	@Autowired
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}

	@Override
	public void add(Emp emp) throws Exception {
		emp.setUserPwd(new MD5Utils().getMD5ofStr(Constants.DEFAULT_EMP_PWD));
		emp.setSex(Constants.DEFAULT_EMP_SEX);
		empDao.insert(emp);
	}
	
	@Override
	public BaseQuery getList(BaseQuery bq) throws Exception {
		List<Emp> us =  empDao.getListPage(bq);
		int total_count = empDao.getCount(bq);
		bq.getPag().setTotal_count(total_count);
		bq.getPag().setPageList(us);
		return bq;
	}
	/**
	 * 删除员工信息
	 */
	@Override
	public void delete(Long empId) throws Exception {
		empDao.delete(empId);
	}
	/**
	 * 修改员工信息
	 */
	@Override
	public void update(Emp emp) throws Exception {
		empDao.update(emp);
	}
	/**
	 * 根据ID获取员工信息
	 */
	@Override
	public Emp getById(Long id) throws Exception {
		return empDao.getById(id);
	}
	/**
	 * 登陆
	 */
	@Override
	public Emp login(Emp emp) throws Exception {
		emp.setUserPwd(new MD5Utils().getMD5ofStr(emp.getUserPwd()));
		System.err.println(emp);
		return empDao.login(emp);
	}
	
	/**
	 * 检测老密码
	 */
	@Override
	public Emp ckOldPwd(Emp emp) throws Exception {
		emp.setUserPwd(new MD5Utils().getMD5ofStr(emp.getUserPwd()));
		return empDao.ckOldPwd(emp);
	}
	/**
	 * 修改密码
	 */
	@Override
	public void updatePwd(Emp emp) throws Exception {
		emp.setUserPwd(new MD5Utils().getMD5ofStr(emp.getUserPwd()));
		empDao.updatePwd(emp);
	}
	

}
