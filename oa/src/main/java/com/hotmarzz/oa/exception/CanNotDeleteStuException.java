package com.hotmarzz.oa.exception;

import com.hotmarzz.basic.exception.BuzzException;

public class CanNotDeleteStuException extends BuzzException{

	private static final long serialVersionUID = 1L;

	public CanNotDeleteStuException(){
		super(ExceptionConstraints.STUDENT_DEL_CODE,ExceptionConstraints.STUDENT_DEL_MSG);
	}
	
}
