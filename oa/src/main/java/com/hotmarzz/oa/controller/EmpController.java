package com.hotmarzz.oa.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
import com.hotmarzz.oa.utils.SessionUtils;

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
	 * 登陆成功页面 (现阶段版本没有登陆页面，有待开发登陆之后再使用)
	 */
	@RequestMapping("main.do")
	public String getMainPage() throws Exception {
		return "main";
	}
	/*
	 * 登陆页面
	 */
	@RequestMapping(value="login.do",method=RequestMethod.POST)
	public String login(Model model,HttpSession session,Emp emp) throws Exception{
		if(emp.getUserName()==null||"".equals(emp.getUserName())
				||emp.getUserPwd()==null||"".equals(emp.getUserPwd())){
			model.addAttribute("errMsg","账号或密码不能为空");
			return "login";
		}
		Emp loginEmp=empBuzz.login(emp);
		if(loginEmp==null){
			model.addAttribute("errMsg","账号或密码有误");
			return "login";
		}
		session.setAttribute(SessionUtils.LOGIN_EMP_KEY, loginEmp);
		return "main";
	}

	/*
	 * 跳转到员工页面
	 */
	@RequestMapping(value = "emps.do")
	public String getEmpPage(Model model, BaseQuery bq) {
		model.addAttribute("bq", bq);
		return "humanResources/emps";
	}

	/*
	 * 查询员工
	 */
	@RequestMapping(value = "getEmpList.do", produces = "application/json;charset=utf-8")
	public @ResponseBody String getEmpList(@RequestBody BaseQuery bq)
			throws Exception {
		//每页大小：可用
		//当前页：可用
		Map<String, Object> queryParams = bq.getQueryParams();
		if (queryParams.containsKey("empName")
				&& StringUtils.isNotEmpty((String) queryParams.get("empName"))) {
			bq.putCondition("empName", Expression.OP_LIKE,
					"%" + queryParams.get("empName") + "%");
		}
		if (queryParams.containsKey("userName")
				&& StringUtils.isNotEmpty((String) queryParams.get("userName"))) {
			bq.putCondition("userName", Expression.OP_LIKE,
					"%" + queryParams.get("userName") + "%");
		}
		if (queryParams.containsKey("hiredate")
				&& StringUtils.isNotEmpty((String) queryParams.get("hiredate"))) {
			bq.putCondition("hiredate", Expression.OP_LE, DateUtils
					.parseSmallTime((String) (queryParams.get("hiredate"))));
		}
		BaseQuery bqResult = empBuzz.getList(bq);
		return JsonUtils.bean2Json(bqResult);
	}

	/*
	 * 跳转添加员工页面
	 */
	@RequestMapping(value = "emp.do", method = RequestMethod.GET)
	public String addFilling(Model model) {
		model.addAttribute("empForm", new Emp());
		return "humanResources/emp";
	}

	/*
	 * 添加员工
	 */
	@RequestMapping(value = "emp.do", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
	public @ResponseBody String add(@RequestBody @Valid Emp emp,
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
		empBuzz.add(emp);
		result.put("flag", true);
		result.put("msg", "添加成功");
		return JsonUtils.bean2Json(result);
	}

	/*
	 * 删除员工
	 */
	@RequestMapping(value = "emp/{id}.do", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@PathVariable("id") Long empId) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();

		empBuzz.delete(empId);

		result.put("flag", true);
		result.put("msg", "success");

		return JsonUtils.bean2Json(result);
	}

	/**
	 * 修改员工前的获取员工信息
	 * 
	 * @param id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "emp/{id}.do", method = RequestMethod.GET)
	public String updateFilling(@PathVariable("id") Long id, Model model)
			throws Exception {
		Emp emp = empBuzz.getById(id);
		model.addAttribute("empForm", emp);
		return "humanResources/emp";
	}

	/**
	 * 修改员工信息
	 * 
	 * @param empId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "emp.do", method = RequestMethod.PUT)
	@ResponseBody
	public String update(@RequestBody @Valid Emp emp, BindingResult results)
			throws Exception {
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

		empBuzz.update(emp);
		result.put("flag", true);
		result.put("msg", "修改成功");
		return JsonUtils.bean2Json(result);
	}
	
	/*
	 * 跳转登陆页面（必须通过controller跳转）
	 */
	@RequestMapping(value = "login.do",method=RequestMethod.GET)
	public String getLoginPage(Model model) throws Exception{
		model.addAttribute("emp", new Emp());
		return "login";
	}
}
