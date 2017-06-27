package com.hotmarzz.oa.buzz.impl;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hotmarzz.basic.dao.BaseQuery;
import com.hotmarzz.basic.dao.Expression;
import com.hotmarzz.basic.utils.DateUtils;
import com.hotmarzz.basic.utils.MD5Utils;
import com.hotmarzz.oa.buzz.EmpBuzz;
import com.hotmarzz.oa.pojo.Dept;
import com.hotmarzz.oa.pojo.Emp;
import com.hotmarzz.oa.pojo.Role;
import com.hotmarzz.oa.pojo.SchoolDistrict;
import com.hotmarzz.oa.pojo.Station;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:application-context.xml"})
public class EmpBuzzImplTest {
	@Autowired
	private EmpBuzz empBuzz;
	
	@Test
	public void testAdd() throws Exception {
		Emp emp = new Emp();
		emp.setEmpName("张三");
		emp.setUserName("dfhm001");
		String pwd = "123456";
		emp.setUserPwd(new MD5Utils().getMD5ofStr(pwd));
		emp.setPhone("1596661234");
		emp.setHiredate(new Date());
		SchoolDistrict sd = new SchoolDistrict();
		sd.setSchoolId(1l);
		Dept d = new Dept();
		d.setDeptId(1l);
		Role r = new Role();
		r.setRoleId(1l);
		Station s = new Station();
		s.setStationId(1l);
		emp.setDept(d);
		emp.setSchoolDistrict(sd);
		emp.setRole(r);
		emp.setStation(s);
		emp.setAssoWeChat(1);
		empBuzz.add(emp);
	}
	
	
	@Test
	public void testGetList() throws Exception{
		BaseQuery bq = new BaseQuery();
		//bq.putCondition("empName", Expression.OP_LIKE, "%2%");
		bq.putCondition("hiredate", Expression.OP_GE, DateUtils.parseSmallTime("2017-06-21"));
		BaseQuery bqResult = empBuzz.getList(bq);
		for(Object o:bqResult.getPag().getPageList()){
			Emp e = (Emp)o;
			System.out.println(e);
		}
	}
}
