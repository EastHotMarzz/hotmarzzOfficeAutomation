package com.hotmarzz.oa.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
	/*
	 * 跳转添加员工页面
	 */
	@RequestMapping(value = "stu.do", method = RequestMethod.GET)
	public String addFilling(Model model) {
		model.addAttribute("stuForm", new Student());
		return "studentResource/stu";
	}
	
	/*
	 * 添加学员
	 */
	@RequestMapping(value = "stu.do", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
	public @ResponseBody String add(@RequestBody @Valid Student stu,
			BindingResult results) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		
		// 数据校验
		if (results.hasErrors()) {
			result.put("flag", "validation");
			Map<String, Object> validationMsg = new HashMap<String, Object>();
			for (FieldError e : results.getFieldErrors()) {
				logger.error("object:" + e.getObjectName() + ";field: "
						+ e.getField() + ";message:" + e.getDefaultMessage());
				validationMsg.put(e.getField(), e.getDefaultMessage());
			}
			result.put("validationMsg", validationMsg);
			return JsonUtils.bean2Json(result);
		}
		
		stuBuzz.add(stu);
		
		result.put("flag", true);
		result.put("msg", "添加成功");
		return JsonUtils.bean2Json(result);
	}
	
	
	
	
}
