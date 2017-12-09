package com.hotmarzz.oa.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hotmarzz.basic.dao.BaseQuery;
import com.hotmarzz.oa.pojo.Student;

@Repository
public interface StudentDao {

	/**
	 * 添加学生
	 * @param stu
	 * @throws Exception
	 */
	void add(Student stu) throws Exception;
	/**
	 * 修改学生
	 * @param stu
	 * @throws Exception
	 */
	void update(Student stu) throws Exception;
	/**
	 * 删除学生信息
	 */
	void delete(Long stuId) throws Exception;
	/**
	 * 根据ID获取学生
	 * @param stuId
	 * @return
	 * @throws Exception
	 */
	Student getById(Long stuId) throws Exception;
	/**
	 * 获取学生信息的集合
	 * @param bq
	 * @return
	 */
	List<Student> getListPage(BaseQuery bq);
	/**
	 * 查询数据个数
	 * @param bq
	 * @return
	 */
	int getCount(BaseQuery bq);
	/**
	 * 检测学员是否重复
	 * @param stu
	 * @return
	 */
	List<Student> checkStuRepeat(Student stu);
	/**
	 * 为锁定时间早于指定时间的学生解锁
	 * @param 
	 */
	void unlockAllByLockTime(Date lockTime) throws Exception;
	
	/*
	 * 获取所有学员
	 */
	List<Student> getAll() throws Exception;
}
