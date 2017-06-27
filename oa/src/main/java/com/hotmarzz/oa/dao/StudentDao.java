package com.hotmarzz.oa.dao;

import org.springframework.stereotype.Repository;

import com.hotmarzz.oa.pojo.Student;

@Repository
public interface StudentDao {

	/**
	 * 添加学生
	 * @param emp
	 * @throws Exception
	 */
	void insert(Student stu) throws Exception;
	/**
	 * 修改学生
	 * @param emp
	 * @throws Exception
	 */
	void update(Student stu) throws Exception;
	/**
	 * 删除学生信息
	 */
	void delete(Long stuId) throws Exception;
	/**
	 * 根据ID获取学生
	 * @param empId
	 * @return
	 * @throws Exception
	 */
	Student getById(Long stuId) throws Exception;
	
}