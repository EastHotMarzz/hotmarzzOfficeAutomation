package com.hotmarzz.oa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hotmarzz.oa.pojo.CampusWater;
import com.hotmarzz.oa.pojo.Subject;
import com.hotmarzz.oa.pojo.SubjectDetail;

@Repository
public interface FinanceDao {

	List<Subject> getSubsList() throws Exception;
	
	List<SubjectDetail> getSubDetailsList(int subId) throws Exception;
	
	Double getSumIncome(String formatDate) throws Exception;
	
	Double getSumExpenditure(String formatDate) throws Exception;
	
	List<CampusWater> getListPage(CampusWater cw) throws Exception;
	
	int getCount(CampusWater cw) throws Exception;
}
