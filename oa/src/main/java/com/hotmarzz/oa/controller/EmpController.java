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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotmarzz.basic.dao.BaseQuery;
import com.hotmarzz.basic.dao.Expression;
import com.hotmarzz.basic.utils.DateUtils;
import com.hotmarzz.basic.utils.JsonUtils;
import com.hotmarzz.basic.utils.StringUtils;
import com.hotmarzz.oa.buzz.EmpBuzz;
import com.hotmarzz.oa.pojo.Emp;

@Controller
public class EmpController {
	
	private Logger logger = LoggerFactory.getLogger(EmpController.class);
	
	private EmpBuzz empBuzz;
	
	public EmpBuzz getEmpBuzz() {
		return empBuzz;
	}
	@Autowired
	public void setEmpBuzz(EmpBuzz empBuzz) {
		this.empBuzz = empBuzz;
	}

	@RequestMapping("main.do")
	public String getMainPage() throws Exception{
		return "main";
	}
	@RequestMapping(value = "login.do",method=RequestMethod.GET)
	public String getLoginPage(Model model) throws Exception{
		model.addAttribute("loginUser", new Emp());
		return "login";
	}
	
	@RequestMapping(value="emps.do")
	public String getEmpPage(Model model,BaseQuery bq){
		model.addAttribute("bq", bq);
		return "humanResources/emps";
	}
	
	@RequestMapping(value="getEmpList.do",produces="application/json;charset=utf-8")
	public @ResponseBody String getEmpList(@RequestBody BaseQuery bq) throws Exception{
		Map<String,Object> queryParams = bq.getQueryParams();
		if(queryParams.containsKey("empName")&&StringUtils.isNotEmpty((String) queryParams.get("empName"))){
			bq.putCondition("empName", Expression.OP_LIKE, "%"+queryParams.get("empName")+"%");
		}
		if(queryParams.containsKey("userName")&&StringUtils.isNotEmpty((String) queryParams.get("userName"))){
			bq.putCondition("userName", Expression.OP_LIKE, "%"+queryParams.get("userName")+"%");
		}
		if(queryParams.containsKey("hiredate")&&StringUtils.isNotEmpty((String) queryParams.get("hiredate"))){
			bq.putCondition("hiredate", Expression.OP_LE, DateUtils.parseSmallTime((String)(queryParams.get("hiredate"))));
		}
		BaseQuery bqResult = empBuzz.getList(bq);
		return JsonUtils.bean2Json(bqResult);
	}
	
	@RequestMapping(value="emp.do",method=RequestMethod.GET)
	public String addFilling(Model model){
		model.addAttribute("empForm", new Emp());
		return "humanResources/emp";
	}
	
	@RequestMapping(value="emp.do",method=RequestMethod.POST)
	public @ResponseBody String add(@RequestBody @Valid @ModelAttribute("empForm") Emp emp, BindingResult results) throws Exception{
		Map<String,Object> result = new HashMap<String,Object>();
		if (results.hasErrors()) {
			result.put("flag", "validation");
			Map<String,Object> validationMsg = new HashMap<String,Object>();
			for (FieldError e : results.getFieldErrors()) {
				logger.error("object:" + e.getObjectName() + ";field: " + e.getField() + ";message:"
						+ e.getDefaultMessage());
				validationMsg.put(e.getField(), e.getDefaultMessage());
			}
			result.put("validationMsg", validationMsg);
			return JsonUtils.bean2Json(result);
		}
		empBuzz.add(emp);
		result.put("flag", true);
		result.put("msg", "添加成功");
		return JsonUtils.bean2Json(result);
	}
}
