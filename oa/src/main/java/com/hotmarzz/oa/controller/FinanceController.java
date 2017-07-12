package com.hotmarzz.oa.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotmarzz.basic.dao.BaseQuery;
import com.hotmarzz.basic.dao.Expression;
import com.hotmarzz.basic.utils.JsonUtils;
import com.hotmarzz.basic.utils.StringUtils;
import com.hotmarzz.oa.buzz.FinanceBuzz;
import com.hotmarzz.oa.pojo.CampusWater;
import com.hotmarzz.oa.pojo.FinanceDto;
import com.hotmarzz.oa.pojo.SubjectDetail;
import com.hotmarzz.oa.utils.FormatDateUtil;

@Controller
public class FinanceController {

	private Logger logger = LoggerFactory.getLogger(EmpController.class);

	private FinanceBuzz finBuzz;

	public FinanceBuzz getFinBuzz() {
		return finBuzz;
	}

	@Autowired
	public void setFinBuzz(FinanceBuzz finBuzz) {
		this.finBuzz = finBuzz;
	}

	@RequestMapping(value = "fins.do", method = RequestMethod.GET)
	public String getFinPage(Model model, CampusWater cw) throws Exception {
		String now = FormatDateUtil.getCurrentYearAndMonthStr();
		String pre = FormatDateUtil.getCurrentYearAndPreMonthStr();
		FinanceDto fin = new FinanceDto();
		// 当月总收入
		Double din = finBuzz.getSumIncome(now);
		// 当月总支出
		Double dout = finBuzz.getSumExpenditure(now);
		// 当月总收入
		Double pin = finBuzz.getSumIncome(pre);
		// 当月总支出
		Double pout = finBuzz.getSumExpenditure(pre);
		if(din==null||dout==null||pin==null||pout==null){
			if(din==null){
				din=0.0;
			}
			if(dout==null){
				dout=0.0;
			}
			if(pin==null){
				pin=0.0;
			}
			if(pout==null){
				pout=0.0;
			}
		}
		fin.setSumIncome(din);
		fin.setSumExpenditure(dout);
		fin.setCurCount(din - dout);
		fin.setPreCount(pin-pout);
		fin.setSumCount((din-dout)+(pin-pout));
		
		cw.setWaterType(0);
		model.addAttribute("subs", finBuzz.getSubsList());
		model.addAttribute("fin", fin);
		model.addAttribute("cw", cw);
		return "financeResources/fins";
	}

	@RequestMapping(value = "getSubDetailsList/{subId}.do", method = RequestMethod.POST)
	@ResponseBody
	public String getSubDetailsList(@PathVariable("subId") int subId)
			throws Exception {
		List<SubjectDetail> subDetails = finBuzz.getSubDetailsList(subId);
		return JsonUtils.bean2Json(subDetails);
	}
	@RequestMapping(value="getFinList.do",method=RequestMethod.POST)
	@ResponseBody
	public String getFinList(@RequestBody CampusWater cw) throws Exception{
		Map<String, Object> queryParams = cw.getQueryParams();
		
		if (queryParams.containsKey("waterType")
				&& StringUtils.isNotEmpty((String) queryParams.get("waterType"))) {
			cw.putCondition("waterType", Expression.OP_EQ,queryParams.get("waterType"));
		}
		if (queryParams.containsKey("startDate")
				&& StringUtils.isNotEmpty((String) queryParams.get("startDate"))) {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			cw.setStartDate(sdf.parse((String)queryParams.get("startDate")));
		}
		if (queryParams.containsKey("endDate")
				&& StringUtils.isNotEmpty((String) queryParams.get("endDate"))) {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			cw.setEndDate(sdf.parse((String)queryParams.get("endDate")));
		}
		if (queryParams.containsKey("subId")
				&& StringUtils.isNotEmpty((String) queryParams.get("subId"))) {
			if(!"0".equals((String) queryParams.get("subId"))){
				cw.putCondition("cw.subjectid", Expression.OP_EQ,queryParams.get("subId"));
			}
		}
		if (queryParams.containsKey("subDetailId")
				&& StringUtils.isNotEmpty((String) queryParams.get("subDetailId"))) {
			if(!"0".equals((String) queryParams.get("subDetailId"))){
				cw.putCondition("cw.subjectdetailid", Expression.OP_EQ,queryParams.get("subDetailId"));
			}
		}
		CampusWater cwResult = finBuzz.getList(cw);
		return JsonUtils.bean2Json(cwResult);
	}
	
	@RequestMapping(value="fin/{fid}.do",method=RequestMethod.DELETE)
	@ResponseBody
	public String delete(@PathVariable("fid") Long fid) throws Exception{
		Map<String, Object> result = new HashMap<String, Object>();

		finBuzz.delete(fid);
		
		result.put("flag", true);
		result.put("msg", "success");

		return JsonUtils.bean2Json(result);
	}
}
