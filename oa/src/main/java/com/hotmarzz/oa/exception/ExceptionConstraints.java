package com.hotmarzz.oa.exception;

public class ExceptionConstraints {
	public static final int STUDENT_REPEAT_CODE = 4001;
	public static final String STUDENT_REPEAT_MSG = "学生已存在，无法操作。锁定人：";
	
	public static final int STUDENT_DEL_CODE = 4002;
	public static final String STUDENT_DEL_MSG = "此学生不是您面试的，无权删除！";
	
	public static final int STUDENT_UPDATE_CODE = 4003;
	public static final String STUDENT_UPDATE_MSG = "此学生不是您面试的，无权修改！";
}
