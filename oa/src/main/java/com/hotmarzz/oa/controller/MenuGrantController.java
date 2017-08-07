package com.hotmarzz.oa.controller;

import java.util.HashMap;
import java.util.List;
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
import com.hotmarzz.oa.buzz.MenuGrantBuzz;
import com.hotmarzz.oa.buzz.ResourceBuzz;
import com.hotmarzz.oa.buzz.RoleBuzz;
import com.hotmarzz.oa.dto.MenuGrantDto;
import com.hotmarzz.oa.pojo.Resource;
import com.hotmarzz.oa.pojo.Student;

@Controller
public class MenuGrantController {

	private Logger logger = LoggerFactory.getLogger(MenuGrantController.class);

	private RoleBuzz roleBuzz;
	private MenuGrantBuzz menuGrantBuzz;
	private ResourceBuzz resourceBuzz;
	
	public RoleBuzz getRoleBuzz() {
		return roleBuzz;
	}
	@Autowired
	public void setRoleBuzz(RoleBuzz roleBuzz) {
		this.roleBuzz = roleBuzz;
	}
	public MenuGrantBuzz getMenuGrantBuzz() {
		return menuGrantBuzz;
	}
	@Autowired
	public void setMenuGrantBuzz(MenuGrantBuzz menuGrantBuzz) {
		this.menuGrantBuzz = menuGrantBuzz;
	}
	public ResourceBuzz getResourceBuzz() {
		return resourceBuzz;
	}
	@Autowired
	public void setResourceBuzz(ResourceBuzz resourceBuzz) {
		this.resourceBuzz = resourceBuzz;
	}
	/*
	 * 跳转到菜单授权页面
	 */
	@RequestMapping(value = "menuGrants.do")
	public String getMenuGrantsPage(Model model, BaseQuery bq) throws Exception {
		model.addAttribute("bq", bq);
		model.addAttribute("roles", roleBuzz.getAll());
		return "permissionResources/menuGrants";
	}
	

	/*
	 * 查询员工
	 */
	@RequestMapping(value = "getMenuGrantList.do", produces = "application/json;charset=utf-8")
	public @ResponseBody String getMenuGrantList(@RequestBody BaseQuery bq)
			throws Exception {
		//每页大小：可用
		//当前页：可用
		Map<String, Object> queryParams = bq.getQueryParams();
		if (queryParams.containsKey("roleId")
				&& StringUtils.isNotEmpty((String) queryParams.get("roleId"))) {
			bq.putCondition("roleId", Expression.OP_EQ,queryParams.get("roleId"));
		}
		BaseQuery bqResult = menuGrantBuzz.getList(bq);
		return JsonUtils.bean2Json(bqResult);
	}

	@RequestMapping(value = "menuGrant.do", method = RequestMethod.GET)
	public String addFilling(Model model) throws Exception {
		model.addAttribute("roles", roleBuzz.getAll());
		model.addAttribute("menus",resourceBuzz.getTreeMenus());
		model.addAttribute("menuGrantForm", new MenuGrantDto());
		return "permissionResources/menuGrant";
	}
	
	//暂时没有使用
//	@RequestMapping(value = "menuGrant/{roleId}.do", method = RequestMethod.GET)
//	public String updateFilling(@PathVariable("roleId") Long roleId, Model model) throws Exception {
//		model.addAttribute("roleId", roleId);
//		model.addAttribute("roles", roleBuzz.getAll());
//		model.addAttribute("menus",resourceBuzz.getTreeMenus());
//		model.addAttribute("grantMenus", menuGrantBuzz.getMenusByRole(roleId));
//		model.addAttribute("menuGrantForm", new MenuGrantDto());
//		return "permissionResources/menuGrant";
//	}
	
	@RequestMapping(value = "getMenuByRoleList.do", produces = "application/json;charset=utf-8")
	public @ResponseBody String getMenuByRoleList(Long roleId)
			throws Exception {
		List<Resource> menus = menuGrantBuzz.getMenusByRole(roleId);
		return JsonUtils.bean2Json(menus);
	}
	
	@RequestMapping(value = "menuGrant.do", method = RequestMethod.POST)
	public @ResponseBody String update(@RequestBody MenuGrantDto menuGrantDto)
			throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		menuGrantBuzz.addOrUpdate(menuGrantDto);
		result.put("flag", true);
		result.put("msg", "授权成功");
		return JsonUtils.bean2Json(result);
	}
}
