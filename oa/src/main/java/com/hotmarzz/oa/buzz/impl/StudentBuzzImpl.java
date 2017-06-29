package com.hotmarzz.oa.buzz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotmarzz.basic.dao.BaseQuery;
import com.hotmarzz.oa.buzz.StudentBuzz;
import com.hotmarzz.oa.dao.StudentDao;
import com.hotmarzz.oa.pojo.Emp;
import com.hotmarzz.oa.pojo.Student;

@Service
public class StudentBuzzImpl implements StudentBuzz {
	
	private StudentDao stuDao;

	public StudentDao getStuDao() {
		return stuDao;
	}
	@Autowired
	public void setStuDao(StudentDao stuDao) {
		this.stuDao = stuDao;
	}

	@Override
	public void add(Student stu) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Student stu) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Student getById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseQuery getList(BaseQuery bq) throws Exception {
		List<Student> us =  stuDao.getListPage(bq);
		int total_count = stuDao.getCount(bq);
		bq.getPag().setTotal_count(total_count);
		bq.getPag().setPageList(us);
		return bq;
	}

	@Override
	public void delete(Long stuId) throws Exception {
		// TODO Auto-generated method stub

	}

}
