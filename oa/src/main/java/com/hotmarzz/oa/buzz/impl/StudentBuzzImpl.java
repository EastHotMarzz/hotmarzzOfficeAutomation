package com.hotmarzz.oa.buzz.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.hotmarzz.basic.dao.BaseQuery;
import com.hotmarzz.oa.buzz.StudentBuzz;
import com.hotmarzz.oa.dao.StudentDao;
import com.hotmarzz.oa.exception.StudentLockException;
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
		Student st = checkStuRepeat(stu);
		if(st!=null){
			throw new StudentRepeatException(st.getLocked(),st.getLockUser());
		}
		stu.setLocked(0);
		stu.setLockTime(new Date());
		stu.setLockUser(((Emp)session.getAttribute(SessionUtils.LOGIN_EMP_KEY)).getEmpName());
		stuDao.add(stu);
	}

	@Override
	public void update(Student stu) throws StudentLockException,StudentRepeatException,Exception {
		//判断是否锁定，检查不通过，抛出异常StudentLockException
		checkLockPermission(stu.getStuId());
		//检查是否重复
		Student st = checkStuRepeat(stu);
		if(st!=null&&!stu.getStuId().equals(st.getStuId())){
			throw new StudentRepeatException();
		}
		stu.setLocked(0);
		stu.setLockTime(new Date());
		stu.setLockUser(((Emp)session.getAttribute(SessionUtils.LOGIN_EMP_KEY)).getEmpName());
		stuDao.update(stu);
	}

	/**
	 * 根据ID获取学员信息
	 */
	@Override
	public Student getById(Long id) throws Exception {
		return stuDao.getById(id);
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
		checkLockPermission(stuId);
		stuDao.delete(stuId);
	}
	
	/*
	 * check repeat stu
	 * norepeat return null
	 * @qi.wang
	 * 20170703 
	 */
	private Student checkStuRepeat(Student stu) throws Exception {
		/*stu.setPhone(stu.getPhone().trim());*/
		List<Student> stus = stuDao.checkStuRepeat(stu);
		if(stus.size()>0){
			return stus.get(0);
		}else{
			return null;
		}
		
	}
	
	/**
	 * 检查指定ID的学生的锁定人，是否与当前登陆人一致。不一致会抛出
	 * @param stuId
	 * @return
	 * @throws Exception
	 */
	private void checkLockPermission(Long stuId) throws StudentLockException,Exception{
		Student stu = stuDao.getById(stuId);
		String loginName =  ((Emp)session.getAttribute(SessionUtils.LOGIN_EMP_KEY)).getEmpName();
		if(stu.getLocked() == 0 && !loginName.equals(stu.getLockUser())){
			throw new StudentLockException(stu.getLockUser());
		}
	}
	
	@Override
	@Scheduled(cron = "0 0 0/1 * * ?")
	public void scheduleUpdateUnlockForStus() throws Exception {
		Date now = new Date();
		Date before = new Date(now.getTime()-MILLI_SECOND_OF_UNLOCK_INTERVAL);
		stuDao.unlockAllByLockTime(before);
	}
	
	
}
