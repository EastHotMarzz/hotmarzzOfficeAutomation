package com.hotmarzz.oa.buzz.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotmarzz.basic.dao.BaseQuery;
import com.hotmarzz.oa.buzz.StudentBuzz;
import com.hotmarzz.oa.controller.EmpController;
import com.hotmarzz.oa.dao.StudentDao;
import com.hotmarzz.oa.exception.CanNotDeleteStuException;
import com.hotmarzz.oa.exception.CanNotUpdateStuException;
import com.hotmarzz.oa.exception.StudentRepeatException;
import com.hotmarzz.oa.pojo.Emp;
import com.hotmarzz.oa.pojo.Student;
import com.hotmarzz.oa.utils.SessionUtils;

@Service
public class StudentBuzzImpl implements StudentBuzz {
	
	private Logger logger = LoggerFactory.getLogger(StudentBuzzImpl.class);

	private StudentDao stuDao;

	public StudentDao getStuDao() {
		return stuDao;
	}
	@Autowired
	public void setStuDao(StudentDao stuDao) {
		this.stuDao = stuDao;
	}
	
	@Autowired
	private HttpSession session;
	
	/**
	 * 添加学员
	 */
	@Override
	public void add(Student stu) throws Exception {
		String lockUserName = checkStuRepeat(stu);
		if(lockUserName!=null){
			throw new StudentRepeatException(lockUserName);
		}
		stu.setLocked(0);
		stu.setLockTime(new Date());
		stu.setLockUser(((Emp)session.getAttribute(SessionUtils.LOGIN_EMP_KEY)).getEmpName());
		stuDao.add(stu);
	}

	@Override
	public void update(Student stu) throws Exception {
		Student stuForUpdate=(Student) session.getAttribute(SessionUtils.FOR_UPDATE);
		String stuName1=stu.getStuName();
		int sex1=stu.getSex();
		int age1=stu.getStuAge();
		
		String stuName2=stuForUpdate.getStuName();
		int sex2=stuForUpdate.getSex();
		int age2=stuForUpdate.getStuAge();
		//判断是否为同一个学生数据
		if(!(stuName1.equals(stuName2) && sex1==sex2 && age1==age2)){
			String lockUserName = checkStuRepeat(stu);
			if(lockUserName!=null){
				throw new StudentRepeatException(lockUserName);
			}
		}
		stuDao.update(stu);
	}

	/**
	 * 根据ID获取学员信息
	 */
	@Override
	public Student getById(Long id) throws Exception {
		return stuDao.getById(id);
	}
	//检测是否能修改专用
	@Override
	public void getById1(Long id) throws Exception {
		Emp e=(Emp)session.getAttribute(SessionUtils.LOGIN_EMP_KEY);
		String loginName=null;
		if(e!=null){
			loginName=e.getEmpName();
		}
		
		String locker=stuDao.getById(id).getLockUser();
		
		if(loginName==null || !loginName.equals(locker)){
			throw new CanNotUpdateStuException();
		}
	}

	/**
	 * 获取学生信息集合
	 */
	@Override
	public BaseQuery getList(BaseQuery bq) throws Exception {
		List<Student> us =  stuDao.getListPage(bq);
		int total_count = stuDao.getCount(bq);
		bq.getPag().setTotal_count(total_count);
		bq.getPag().setPageList(us);
		return bq;
	}

	/**
	 * 删除学员
	 */
	@Override
	public void delete(Long stuId) throws Exception {
		Emp e=(Emp)session.getAttribute(SessionUtils.LOGIN_EMP_KEY);
		String loginName=null;
		if(e!=null){
			loginName=e.getEmpName();
		}
		
		String locker=stuDao.getById(stuId).getLockUser();
		
		if(loginName==null || !loginName.equals(locker)){
			throw new CanNotDeleteStuException();
		}
		stuDao.delete(stuId);
	}
	
	/*
	 * check repeat stu
	 * if repeat return lockUserName
	 * norepeat return null
	 * @qi.wang
	 * 20170703 
	 */
	private String checkStuRepeat(Student stu) throws Exception {
		Student s = stuDao.checkStuRepeat(stu);
		if(s!=null){
			return s.getLockUser();
		}else{
			return null;
		}
	}

}
