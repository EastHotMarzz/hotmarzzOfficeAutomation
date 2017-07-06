package com.hotmarzz.oa.exception;

import com.hotmarzz.basic.exception.BuzzException;

public class CanNotUpdateStuException extends BuzzException{

	private static final long serialVersionUID = 1L;

	public CanNotUpdateStuException(){
		super(ExceptionConstraints.STUDENT_UPDATE_CODE,ExceptionConstraints.STUDENT_UPDATE_MSG);
	}
	
}
