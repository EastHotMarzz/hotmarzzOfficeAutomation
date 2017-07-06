package com.hotmarzz.oa.exception;

import com.hotmarzz.basic.exception.BuzzException;

public class StudentLockException extends BuzzException{
	public StudentLockException(String lockUserName){
		super(ExceptionConstraints.STUDENT_LOCK_CODE,ExceptionConstraints.STUDENT_LOCK_MSG+lockUserName);
	}
	
	public StudentLockException(int code,String msg){
		super(code,msg);
	}
}
