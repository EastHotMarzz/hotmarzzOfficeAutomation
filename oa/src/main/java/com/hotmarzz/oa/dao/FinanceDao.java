package com.hotmarzz.oa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hotmarzz.oa.dto.CampusWaterDto;
import com.hotmarzz.oa.pojo.CampusWater;
import com.hotmarzz.oa.pojo.FinSubject;
import com.hotmarzz.oa.pojo.FinSubjectDetail;
import com.hotmarzz.oa.pojo.Financial;
import com.hotmarzz.oa.pojo.Subject;
import com.hotmarzz.oa.pojo.SubjectDetail;

@Repository
public interface FinanceDao {

	List<Subject> getSubsList() throws Exception;
	
	List<SubjectDetail> getSubDetailsList(Long subId) throws Exception;
	
	Double getSumIncome(String formatDate,Long sid) throws Exception;
	
	Double getSumExpenditure(String formatDate,Long sid) throws Exception;
	
	List<CampusWater> getListPage(CampusWater cw) throws Exception;
	
	int getCount(CampusWater cw) throws Exception;
	
	void delete(Long fid) throws Exception;
	
	void add(CampusWaterDto cw) throws Exception;
	
	CampusWater getById(Long wid) throws Exception;
	
	void update(CampusWaterDto cwd) throws Exception;
	
	Double getCurrentYearWaterSum(Long schoolId) throws Exception;
	
	List<FinSubject> getFinSubsList() throws Exception;
	
	List<FinSubjectDetail> getFinSubDetailsList(Long subId) throws Exception;
	
	void addFin(Financial fin) throws Exception;
	
	public String getCurrentBillPath(Long id) throws Exception;
	
	public void updateBillPath(CampusWater cw) throws Exception;
}
