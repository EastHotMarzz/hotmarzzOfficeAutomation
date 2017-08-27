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
import com.hotmarzz.oa.buzz.SchoolBuzz;
import com.hotmarzz.oa.pojo.Emp;
import com.hotmarzz.oa.pojo.Role;
import com.hotmarzz.oa.pojo.SchoolDistrict;

@Controller
public class SchoolController {
	private Logger logger = LoggerFactory.getLogger(SchoolController.class);
	
	private SchoolBuzz schoolBuzz;
	public SchoolBuzz getSchoolBuzz() {
		return schoolBuzz;
	}
	@Autowired
	public void setSchoolBuzz(SchoolBuzz schoolBuzz) {
		this.schoolBuzz = schoolBuzz;
	}

	/*
	 * 跳转校区页面
	 */
	@RequestMapping(value = "schools.do", method = RequestMethod.GET)
	public String getStuPage(Model model, BaseQuery bq) {
		model.addAttribute("bq", bq);
		return "schoolResources/schools";
	}
	
	/*
	 * 跳转校区添加页面
	 */
	@RequestMapping(value = "school.do", method = RequestMethod.GET)
	public String addFilling(Model model) throws Exception {
		model.addAttribute("schoolForm", new SchoolDistrict());
		return "schoolResources/school";
	}
	
	/*
	 * 校区添加
	 */
	@RequestMapping(value = "school.do", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
	public @ResponseBody String add(@RequestBody @Valid SchoolDistrict sd,
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
		schoolBuzz.add(sd);
		result.put("flag", true);
		result.put("msg", "添加成功");
		return JsonUtils.bean2Json(result);
	}
	
	/*
	 * 校区修改前 获取校区信息
	 */
	@RequestMapping(value = "school/{id}.do", method = RequestMethod.GET)
	public String updateFilling(@PathVariable("id") Long id, Model model)
			throws Exception {
		//根据id查询校区信息
		SchoolDistrict sd = schoolBuzz.getById(id);
		model.addAttribute("schoolForm", sd);
		return "schoolResources/school";
	}
	
	/*
	 * 修改校区信息
	 */
	@RequestMapping(value = "school.do", method = RequestMethod.PUT)
	@ResponseBody
	public String update(@RequestBody @Valid SchoolDistrict sd, BindingResult results)
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

		schoolBuzz.update(sd);
		result.put("flag", true);
		result.put("msg", "修改成功");
		return JsonUtils.bean2Json(result);
	}
	
	/*
	 * 校区删除
	 */
	@RequestMapping(value = "school/{id}.do", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@PathVariable("id") Long schoolId) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		schoolBuzz.delete(schoolId);
		result.put("flag", true);
		result.put("msg", "success");

		return JsonUtils.bean2Json(result);
	}
	
	
	@RequestMapping(value="getSchoolList.do",method=RequestMethod.POST)
	@ResponseBody
	public String getSchoolList(@RequestBody BaseQuery bq) throws Exception{
		
		Map<String, Object> queryParams = bq.getQueryParams();
		if (queryParams.containsKey("schoolName")
				&& StringUtils.isNotEmpty((String) queryParams.get("schoolName"))) {
			bq.putCondition("schoolName", Expression.OP_LIKE,
					"%" + queryParams.get("schoolName") + "%");
		}
		
		if (queryParams.containsKey("province")
				&& StringUtils.isNotEmpty((String) queryParams.get("province"))) {
			bq.putCondition("province", Expression.OP_LIKE,
					"%" + queryParams.get("province") + "%");
		}
		BaseQuery bqResult =schoolBuzz.getList(bq);
		return JsonUtils.bean2Json(bqResult);
	}
}
