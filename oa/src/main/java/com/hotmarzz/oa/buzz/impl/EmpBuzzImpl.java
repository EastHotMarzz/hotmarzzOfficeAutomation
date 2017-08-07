package com.hotmarzz.oa.buzz.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotmarzz.basic.dao.BaseQuery;
import com.hotmarzz.basic.utils.MD5Utils;
import com.hotmarzz.oa.buzz.EmpBuzz;
import com.hotmarzz.oa.buzz.ResourceBuzz;
import com.hotmarzz.oa.dao.EmpDao;
import com.hotmarzz.oa.pojo.Emp;
import com.hotmarzz.oa.pojo.EmpRoleLink;
import com.hotmarzz.oa.pojo.Resource;
import com.hotmarzz.oa.pojo.Role;
import com.hotmarzz.oa.pojo.RoleResourceLink;
import com.hotmarzz.oa.utils.Constants;

@Service
public class EmpBuzzImpl implements EmpBuzz {
	
	private EmpDao empDao;
	private ResourceBuzz reousrceBuzz;
	
	public EmpDao getEmpDao() {
		return empDao;
	}
	@Autowired
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}
	
	public ResourceBuzz getReousrceBuzz() {
		return reousrceBuzz;
	}
	@Autowired
	public void setReousrceBuzz(ResourceBuzz reousrceBuzz) {
		this.reousrceBuzz = reousrceBuzz;
	}
	@Override
	@Transactional
	public void add(Emp emp) throws Exception {
		emp.setUserPwd(new MD5Utils().getMD5ofStr(Constants.DEFAULT_EMP_PWD));
		emp.setSex(Constants.DEFAULT_EMP_SEX);
		empDao.insert(emp);
		addEmpRoleLinks(emp);
	}
	
	@Override
	@Transactional
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
	@Transactional
	public void delete(Long empId) throws Exception {
		empDao.delete(empId);
		deleteERLByEmp(empId);
	}
	/**
	 * 修改员工信息
	 */
	@Override
	@Transactional
	public void update(Emp emp) throws Exception {
		empDao.update(emp);
		deleteERLByEmp(emp.getEmpId());
		addEmpRoleLinks(emp);
	}
	/**
	 * 根据ID获取员工信息
	 */
	@Override
	@Transactional
	public Emp getById(Long id) throws Exception {
		return empDao.getById(id);
	}
	/**
	 * 登陆
	 */
	@Override
	@Transactional
	public Emp login(Emp emp) throws Exception {
		emp.setUserPwd(new MD5Utils().getMD5ofStr(emp.getUserPwd()));
		return empDao.login(emp);
	}
	
	/**
	 * 检测老密码
	 */
	@Override
	@Transactional
	public Emp ckOldPwd(Emp emp) throws Exception {
		emp.setUserPwd(new MD5Utils().getMD5ofStr(emp.getUserPwd()));
		return empDao.ckOldPwd(emp);
	}
	/**
	 * 修改密码
	 */
	@Override
	@Transactional
	public void updatePwd(Emp emp) throws Exception {
		emp.setUserPwd(new MD5Utils().getMD5ofStr(emp.getUserPwd()));
		empDao.updatePwd(emp);
	}
	
	@Transactional
	public void addEmpRoleLinks(Emp emp) throws Exception {
		//添加关联
		Long[] roleIds = emp.getRoleIds();
		if(roleIds!=null&&roleIds.length>0){
			for(Long roleId:roleIds){
				EmpRoleLink empRoleLink = new EmpRoleLink();
				empRoleLink.setEmpId(emp.getEmpId());
				empRoleLink.setRoleId(roleId);
				addEmpRoleLink(empRoleLink);
			}
		}		
	}
	public void addEmpRoleLink(EmpRoleLink empRoleLink) throws Exception {
		empDao.insertEmpRoleLink(empRoleLink);
	}
	@Transactional
	public void deleteERLByEmp(Long empId) throws Exception {
		empDao.deleteERLByEmp(empId);
	}
	@Override
	public List<Resource> getMenusOfEmp(Emp emp) throws Exception {
		List<Resource> res = new ArrayList<Resource>();
		List<RoleResourceLink> rrs = reousrceBuzz.getRoleMenuList();
		List<Role> empRoles = emp.getRoles();
		if(rrs!=null&&rrs.size()>0&&empRoles!=null&&empRoles.size()>0){
			for(RoleResourceLink rr:rrs){
				for(Role r:empRoles){
					if(r.equals(rr.getRole())){
						Resource menu = rr.getResource();
						if(!res.contains(menu)){
							res.add(menu);
						}
					}
				}
			}
		}
		return res;
	}

}
