package com.hotmarzz.oa.buzz;

import com.hotmarzz.basic.dao.BaseQuery;
import com.hotmarzz.oa.pojo.Student;

public interface StudentBuzz {
	
	long MILLI_SECOND_OF_UNLOCK_INTERVAL = 7*24*3600*1000;
	
	void add(Student stu) throws Exception;
	/**
	 * 修改学生数据
	 * @param emp
	 * @throws Exception
	 */
	void update(Student stu) throws Exception;
	/**
	 * 根据ID修改学生数据
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Student getById(Long id) throws Exception;
	
	BaseQuery getList(BaseQuery bq) throws Exception;
	/**
	 * 删除学生
	 * @param empId 
	 * @throws Exception
	 */
	void delete(Long stuId) throws Exception;
	/**
	 * 根据DAY_OF_UNLOCK_INTERVAL
	 * 为锁定时间，早于当前时间与指定时间差的学生解锁
	 * @throws Exception
	 */
	void updateUnlockForStus() throws Exception;
}
