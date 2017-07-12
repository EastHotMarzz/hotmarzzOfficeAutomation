package com.hotmarzz.oa.buzz.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotmarzz.oa.buzz.FinanceBuzz;
import com.hotmarzz.oa.dao.FinanceDao;
import com.hotmarzz.oa.pojo.CampusWater;
import com.hotmarzz.oa.pojo.Student;
import com.hotmarzz.oa.pojo.Subject;
import com.hotmarzz.oa.pojo.SubjectDetail;

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
	
	@Override
	public List<Subject> getSubsList() throws Exception {
		return finDao.getSubsList();
	}
	@Override
	public List<SubjectDetail> getSubDetailsList(int subId) throws Exception {
		return finDao.getSubDetailsList(subId);
	}
	@Override
	public Double getSumIncome(String formatDate) throws Exception {
		return finDao.getSumIncome(formatDate);
	}
	@Override
	public Double getSumExpenditure(String formatDate) throws Exception {
		return finDao.getSumExpenditure(formatDate);
	}
	
	
	@Override
	public CampusWater getList(CampusWater cw) throws Exception {
		List<CampusWater> us =  finDao.getListPage(cw);
		int total_count = finDao.getCount(cw);
		cw.getPag().setTotal_count(total_count);
		cw.getPag().setPageList(us);
		return cw;
	}
	
	
}
