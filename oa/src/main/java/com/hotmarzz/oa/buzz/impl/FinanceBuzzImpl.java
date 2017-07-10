package com.hotmarzz.oa.buzz.impl;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotmarzz.oa.buzz.FinanceBuzz;
import com.hotmarzz.oa.dao.FinanceDao;

@Service
public class FinanceBuzzImpl implements FinanceBuzz{

	private Logger logger = LoggerFactory.getLogger(FinanceBuzzImpl.class);
	
	@Autowired
	private HttpSession session;
	
	private FinanceDao finDao;

	public FinanceDao getFinDao() {
		return finDao;
	}
	@Autowired
	public void setFinDao(FinanceDao finDao) {
		this.finDao = finDao;
	}
	
	
}
