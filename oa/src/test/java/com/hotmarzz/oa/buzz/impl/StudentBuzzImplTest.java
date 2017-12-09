package com.hotmarzz.oa.buzz.impl;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hotmarzz.oa.buzz.StudentBuzz;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:application-context.xml")
@WebAppConfiguration() 
public class StudentBuzzImplTest {
	@Autowired
	private HttpSession httpSession;
	@Autowired
	private StudentBuzz stuBuzz;
	
	@Test
	public void test() throws Exception {
		stuBuzz.getAllExcelX();
	}

}
