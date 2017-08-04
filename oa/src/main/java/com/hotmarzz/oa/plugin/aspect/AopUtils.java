package com.hotmarzz.oa.plugin.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

public class AopUtils {
	public static Method getSourceMethod(JoinPoint jp){
		Method proxyMethod = ((MethodSignature)(jp.getSignature())).getMethod();
		try {
			return jp.getTarget().getClass().getMethod(proxyMethod.getName(), proxyMethod.getParameterTypes());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}
}
