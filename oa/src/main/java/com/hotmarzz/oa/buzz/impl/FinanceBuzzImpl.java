package com.hotmarzz.oa.buzz.impl;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotmarzz.oa.buzz.FinanceBuzz;
import com.hotmarzz.oa.dao.FinanceDao;
import com.hotmarzz.oa.dto.CampusWaterDto;
import com.hotmarzz.oa.pojo.CampusWater;
import com.hotmarzz.oa.pojo.Emp;
import com.hotmarzz.oa.pojo.FinSubject;
import com.hotmarzz.oa.pojo.FinSubjectDetail;
import com.hotmarzz.oa.pojo.Financial;
import com.hotmarzz.oa.pojo.SchoolDistrict;
import com.hotmarzz.oa.pojo.Subject;
import com.hotmarzz.oa.pojo.SubjectDetail;
import com.hotmarzz.oa.utils.SessionUtils;

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
	public List<SubjectDetail> getSubDetailsList(Long subId) throws Exception {
		return finDao.getSubDetailsList(subId);
	}
	@Override
	public Double getSumIncome(String formatDate) throws Exception {
		Emp emp=(Emp) session.getAttribute(SessionUtils.LOGIN_EMP_KEY);
		long sid=emp.getSchoolDistrict().getSchoolId();
		return finDao.getSumIncome(formatDate,sid);
	}
	@Override
	public Double getSumExpenditure(String formatDate) throws Exception {
		Emp emp=(Emp) session.getAttribute(SessionUtils.LOGIN_EMP_KEY);
		long sid=emp.getSchoolDistrict().getSchoolId();
		return finDao.getSumExpenditure(formatDate,sid);
	}
	
	
	@Override
	public CampusWater getList(CampusWaterDto cw) throws Exception {
		cw.setSchoolIdDto(((Emp)(session.getAttribute(SessionUtils.LOGIN_EMP_KEY))).getSchoolDistrict().getSchoolId());
		System.err.println("---other---"+cw.getConditions().size());
		List<CampusWater> us =  finDao.getListPage(cw);
		int total_count = finDao.getCount(cw);
		cw.getPag().setTotal_count(total_count);
		cw.getPag().setPageList(us);
		return cw;
	}
	
	@Override
	public void delete(Long fid) throws Exception {
		finDao.delete(fid);
	}
	@Override
	public void add(CampusWaterDto cw) throws Exception {
		//默认为登录人所在校区
		cw.setSchoolIdDto(((Emp)(session.getAttribute(SessionUtils.LOGIN_EMP_KEY))).getSchoolDistrict().getSchoolId());
		//默认流水批次为当前月份
		Calendar cal=Calendar.getInstance();
		int month=cal.get(Calendar.MONTH)+1;
		cw.setWaterBanch(month+"月");
		//默认经手人为登录人
		cw.setBrokerage(((Emp)(session.getAttribute(SessionUtils.LOGIN_EMP_KEY))).getEmpName());
		cw.setCreateUser(((Emp)(session.getAttribute(SessionUtils.LOGIN_EMP_KEY))).getEmpName());
		finDao.add(cw);
	}
	@Override
	public CampusWater getById(Long wid) throws Exception {
		return finDao.getById(wid);
	}
	@Override
	public void update(CampusWaterDto cwd) throws Exception {
		finDao.update(cwd);
	}
	@Override
	public Double getCurrentYearWaterSum(Long schoolId) throws Exception {
		return finDao.getCurrentYearWaterSum(schoolId);
	}
	@Override
	public List<FinSubject> getFinSubsList() throws Exception {
		return finDao.getFinSubsList();
	}
	@Override
	public List<FinSubjectDetail> getFinSubDetailsList(Long subId)
			throws Exception {
		return finDao.getFinSubDetailsList(subId);
	}
	
	
	@Override
	public void addFin(Financial fin) throws Exception {
		//申请人
		fin.setApplyUser(((Emp)(session.getAttribute(SessionUtils.LOGIN_EMP_KEY))).getEmpName());
		//创建人
		fin.setCreateUser(((Emp)(session.getAttribute(SessionUtils.LOGIN_EMP_KEY))).getEmpName());
		//申请状态
		fin.setFinStatus("未审核");
		
		finDao.addFin(fin);
	}
	@Override
	public List<CampusWater> getExpList(CampusWater cw) throws Exception {
		return finDao.getListPage(cw);
	}
	
	
	@Override
	public void updateBillPath(CampusWater cw) throws Exception {
		finDao.updateBillPath(cw);
	}
	
	
	@Override
	public String getCurrentBillPath(Long id) throws Exception {
		return finDao.getCurrentBillPath(id);
	}
	
	
}
