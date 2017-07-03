package com.hotmarzz.oa.exception;

import com.hotmarzz.basic.exception.BuzzException;

public class StudentRepeatException extends BuzzException{

	private static final long serialVersionUID = 1L;

	public StudentRepeatException(){
		super(ExceptionConstraints.STUDENT_REPEAT_CODE,ExceptionConstraints.STUDENT_REPEAT_MSG);
	}
	
	public StudentRepeatException(int code,String msg){
		super(code,msg);
	}
}
