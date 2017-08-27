package com.hotmarzz.oa.buzz.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hotmarzz.oa.pojo.Emp;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:application-context.xml"})
public class FinanceDaoImplTest {
	@Autowired
//	private FinanceDao dao;
	
	@Test
	public void testGetList() throws Exception{
//		List<Emp> list=dao.getFinEmps(1);
//		System.out.println(list);
	}
}
