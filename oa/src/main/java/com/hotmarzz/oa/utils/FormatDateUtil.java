package com.hotmarzz.oa.utils;

import java.util.Calendar;

public class FormatDateUtil {

	public static final String getCurrentYearAndMonthStr(){
		Calendar ca=Calendar.getInstance();
		int year = ca.get(Calendar.YEAR);
		int month = ca.get(Calendar.MONTH)+1;
		String formatDate=null;
		if(month<10){
			formatDate=year+"-0"+month;
		}else{
			formatDate=year+"-"+month;
		}
		return formatDate;
	}
	
	public static final String getCurrentYearAndPreMonthStr(){
		Calendar ca=Calendar.getInstance();
		int year = ca.get(Calendar.YEAR);
		int month = ca.get(Calendar.MONTH);
		String formatDate=null;
		if(month<10){
			formatDate=year+"-0"+month;
		}else{
			formatDate=year+"-"+month;
		}
		return formatDate;
	}
}
