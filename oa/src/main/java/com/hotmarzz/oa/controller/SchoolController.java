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
import com.hotmarzz.oa.buzz.SchoolBuzz;

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
