package com.hotmarzz.oa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hotmarzz.oa.buzz.StudentBuzz;

@Controller
public class StudentController {

	private Logger logger = LoggerFactory.getLogger(EmpController.class);
	
	private StudentBuzz stuBuzz;

	public StudentBuzz getStuBuzz() {
		return stuBuzz;
	}
	@Autowired
	public void setStuBuzz(StudentBuzz stuBuzz) {
		this.stuBuzz = stuBuzz;
	}
	
	
	private String getStuList(){
		
		return null;
	}
	
}
