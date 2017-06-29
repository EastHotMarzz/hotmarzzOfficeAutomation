package com.hotmarzz.oa.dao;

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
}
