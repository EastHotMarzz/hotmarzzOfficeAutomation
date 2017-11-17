package com.hotmarzz.oa.exception;

public class ExceptionConstraints {
	public static final int STUDENT_REPEAT_CODE = 4001;
	public static final String STUDENT_REPEAT_MSG = "学员(姓名，年龄，性别重复)已存在，无法重复输入！";
	public static final int STUDENT_LOCK_CODE = 4002;
	public static final String STUDENT_LOCK_MSG = "该学员被他人锁定，无法修改或删除。锁定人：";
}
