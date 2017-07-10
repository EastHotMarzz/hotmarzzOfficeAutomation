package com.hotmarzz.oa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotmarzz.basic.dao.BaseQuery;
import com.hotmarzz.oa.buzz.FinanceBuzz;

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
	
	@RequestMapping(value="fins.do",method=RequestMethod.GET)
	public String getFinPage(Model model, BaseQuery bq){
		model.addAttribute("bq", bq);
		return "financeResources/fins";
	}
}
