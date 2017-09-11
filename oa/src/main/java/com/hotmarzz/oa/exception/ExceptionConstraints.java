package com.hotmarzz.oa.exception;

public class ExceptionConstraints {
	public static final int STUDENT_REPEAT_CODE = 4001;
	public static final String STUDENT_REPEAT_MSG = "学员手机号已存在，无法添加或修改。锁定人：";
	public static final int STUDENT_LOCK_CODE = 4002;
	public static final String STUDENT_LOCK_MSG = "该学员被他人锁定，无法修改或删除。锁定人：";
}
