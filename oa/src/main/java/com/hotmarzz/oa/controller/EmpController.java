package com.hotmarzz.oa.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Delete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

	/*
	 * 登陆成功页面
	 * (现阶段版本没有登陆页面，有待开发登陆之后再使用)
	 */
	@RequestMapping("main.do")
	public String getMainPage() throws Exception{
		return "main";
	}
	
	/*
	 * 跳转到员工页面
	 */
	@RequestMapping(value="emps.do")
	public String getEmpPage(Model model,BaseQuery bq){
		model.addAttribute("bq", bq);
		return "humanResources/emps";
	}
	/*
	 * 查询员工
	 */
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
	
	/*
	 * 跳转添加员工页面
	 */
	@RequestMapping(value="emp.do",method=RequestMethod.GET)
	public String addFilling(Model model){
		model.addAttribute("empForm", new Emp());
		return "humanResources/emp";
	}
	
	/*
	 * 添加员工
	 */
	@RequestMapping(value="emp.do",produces="application/json;charset=UTF-8",method=RequestMethod.POST)
	public @ResponseBody String add(@RequestBody @Valid Emp emp, BindingResult results) throws Exception{
		Map<String,Object> result = new HashMap<String,Object>();
		//数据校验
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
	
	/*
	 * 删除员工
	 */
	@RequestMapping(value="emp/{id}.do",method=RequestMethod.DELETE)
	@ResponseBody
	public String deleteEmp(@PathVariable("id") Integer id){
		Map<String,Object> result = new HashMap<String,Object>();
		
//		empBuzz
		
		
		
		result.put("flag", true);
		result.put("msg", "success");
		
		return JsonUtils.bean2Json(result);
	}
}
