package com.hotmarzz.oa.buzz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotmarzz.basic.dao.BaseQuery;
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
		emp.setUserPwd(Constants.DEFAULT_EMP_PWD);
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

}
