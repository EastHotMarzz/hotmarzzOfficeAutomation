package com.hotmarzz.oa.utils;

import java.text.DecimalFormat;

public class FormatNumberUtil {

	public static Double formartTwoPoint(Double num){
		DecimalFormat df = new DecimalFormat("#.000");
		String str=df.format(num);
		return Double.parseDouble(str);
	}
	
}
