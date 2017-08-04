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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotmarzz.basic.dao.BaseQuery;
import com.hotmarzz.basic.dao.Expression;
import com.hotmarzz.basic.utils.JsonUtils;
import com.hotmarzz.basic.utils.StringUtils;
import com.hotmarzz.oa.buzz.RoleBuzz;
import com.hotmarzz.oa.pojo.Role;
import com.hotmarzz.oa.utils.JSONConstrants;

@Controller
public class RoleController {

	private Logger logger = LoggerFactory.getLogger(RoleController.class);

	private RoleBuzz roleBuzz;

	public RoleBuzz getRoleBuzz() {
		return roleBuzz;
	}
	@Autowired
	public void setRoleBuzz(RoleBuzz roleBuzz) {
		this.roleBuzz = roleBuzz;
	}

	/*
	 * 跳转到角色页面
	 */
	@RequestMapping(value = "roles.do")
	public String getRolePage(Model model, BaseQuery bq) {
		model.addAttribute("bq", bq);
		return "permissionResources/roles";
	}
	
	/*
	 * 查询角色
	 */
	@RequestMapping(value = "getRoleList.do", produces = "application/json;charset=utf-8")
	public @ResponseBody String getRoleList(@RequestBody BaseQuery bq)
			throws Exception {
		Map<String, Object> queryParams = bq.getQueryParams();
		if (queryParams.containsKey("roleName")
				&& StringUtils.isNotEmpty((String) queryParams.get("roleName"))) {
			bq.putCondition("roleName", Expression.OP_LIKE,
					"%" + queryParams.get("roleName") + "%");
		}
		BaseQuery bqResult = roleBuzz.getList(bq);
		return JsonUtils.bean2Json(bqResult);
	}

	/*
	 * 跳转添加角色页面
	 */
	@RequestMapping(value = "role.do", method = RequestMethod.GET)
	public String addFilling(Model model) {
		model.addAttribute("roleForm", new Role());
		return "permissionResources/role";
	}

	/*
	 * 添加角色
	 */
	@RequestMapping(value = "role.do", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
	public @ResponseBody String add(@RequestBody @Valid Role role,
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
		roleBuzz.add(role);
		result.put(JSONConstrants.FLAG, JSONConstrants.FLAG_SUCCESS);
		result.put(JSONConstrants.FLAG_MSG, JSONConstrants.ADD_SUCCESS_MSG);
		return JsonUtils.bean2Json(result);
	}

	/*
	 * 删除角色
	 */
	@RequestMapping(value = "role/{roleId}.do", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@PathVariable("roleId") Long roleId) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		roleBuzz.delete(roleId);
		result.put(JSONConstrants.FLAG, JSONConstrants.FLAG_SUCCESS);
		result.put(JSONConstrants.FLAG_MSG, JSONConstrants.DELETE_SUCCESS_MSG);
		return JsonUtils.bean2Json(result);
	}

	/**
	 * 修改角色前的获取角色信息
	 * 
	 * @param id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "role/{roleId}.do", method = RequestMethod.GET)
	public String updateFilling(@PathVariable("roleId") Long roleId, Model model)
			throws Exception {
		Role role = roleBuzz.getById(roleId);
		model.addAttribute("roleForm", role);
		return "permissionResources/role";
	}

	/**
	 * 修改员工信息
	 * 
	 * @param empId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "role.do", method = RequestMethod.PUT)
	@ResponseBody
	public String update(@RequestBody @Valid Role role, BindingResult results)
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
		roleBuzz.update(role);
		result.put(JSONConstrants.FLAG, JSONConstrants.FLAG_SUCCESS);
		result.put(JSONConstrants.FLAG_MSG, JSONConstrants.UPDATE_SUCCESS_MSG);
		return JsonUtils.bean2Json(result);
	}
	
}
