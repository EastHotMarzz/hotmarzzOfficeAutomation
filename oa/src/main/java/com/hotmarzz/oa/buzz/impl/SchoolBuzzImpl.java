package com.hotmarzz.oa.buzz.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotmarzz.basic.dao.BaseQuery;
import com.hotmarzz.oa.buzz.SchoolBuzz;
import com.hotmarzz.oa.dao.SchoolDao;
import com.hotmarzz.oa.pojo.SchoolDistrict;
import com.hotmarzz.oa.pojo.Student;

@Service
public class SchoolBuzzImpl implements SchoolBuzz {

	private Logger logger = LoggerFactory.getLogger(SchoolBuzzImpl.class);
	private SchoolDao schoolDao;
	public SchoolDao getSchoolDao() {
		return schoolDao;
	}
	@Autowired
	public void setSchoolDao(SchoolDao schoolDao) {
		this.schoolDao = schoolDao;
	}
	@Autowired
	private HttpSession session;
	
	/**
	 * 分页查询校区信息
	 */
	@Override
	public BaseQuery getList(BaseQuery bq) throws Exception {
		List<SchoolDistrict> us =  schoolDao.getListPage(bq);
		int total_count = schoolDao.getCount(bq);
		bq.getPag().setTotal_count(total_count);
		bq.getPag().setPageList(us);
		return bq;
	}
	
}
