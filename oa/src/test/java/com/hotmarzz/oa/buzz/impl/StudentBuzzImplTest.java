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
import com.hotmarzz.oa.buzz.StudentBuzz;
import com.hotmarzz.oa.pojo.Dept;
import com.hotmarzz.oa.pojo.Emp;
import com.hotmarzz.oa.pojo.Role;
import com.hotmarzz.oa.pojo.SchoolDistrict;
import com.hotmarzz.oa.pojo.Station;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:application-context.xml"})
public class StudentBuzzImplTest {
	@Autowired
	private StudentBuzz stuBuzz;
	
	@Test
	public void testUnLock() throws Exception {
		stuBuzz.updateUnlockForStus();
	}	
	
}
