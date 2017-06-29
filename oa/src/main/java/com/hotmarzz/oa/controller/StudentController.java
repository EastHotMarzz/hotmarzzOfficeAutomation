package com.hotmarzz.oa.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotmarzz.basic.dao.BaseQuery;
import com.hotmarzz.basic.dao.Expression;
import com.hotmarzz.basic.utils.JsonUtils;
import com.hotmarzz.basic.utils.StringUtils;
import com.hotmarzz.oa.buzz.StudentBuzz;
import com.hotmarzz.oa.pojo.Student;

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
	
	
	/*
	 * 跳转学生页面
	 */
	@RequestMapping(value="stus.do",method=RequestMethod.GET)
	public String getStusList(Model model,BaseQuery bq){
		model.addAttribute("bq", bq);
		return "studentResource/stus";
	}
	/*
	 * 查询学员信息
	 */
	@RequestMapping(value="getStuList.do",method=RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getStuList(@RequestBody BaseQuery bq) throws Exception{

		Map<String, Object> queryParams = bq.getQueryParams();
		if (queryParams.containsKey("stuName")
				&& StringUtils.isNotEmpty((String) queryParams.get("stuName"))) {
			bq.putCondition("stuName", Expression.OP_LIKE,
					"%" + queryParams.get("stuName") + "%");
		}
		
		BaseQuery bqResult = stuBuzz.getList(bq);
		return JsonUtils.bean2Json(bqResult);
	}
}
