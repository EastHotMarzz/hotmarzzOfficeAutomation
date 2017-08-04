package com.hotmarzz.oa.plugin.aspect;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.hotmarzz.basic.utils.StringUtils;
import com.hotmarzz.oa.pojo.Emp;
import com.hotmarzz.oa.utils.SessionUtils;



/*
 * set operation info : who do,when do for save or update
 * 方法名限制：
 * 		添加方法save或者insert开头
 * 		修改方法update开头
 */
@Component
@Aspect
@Order(20)
public class SaveUpdateAspect {
	
	private static final String CREATE_USER = "createUser";
	private static final String CREATE_DATE = "createDate";
	private static final String UPDATE_USER = "updateUser";
	private static final String UPDATE_DATE = "updateDate";
	
	@Autowired
	private HttpSession session;
	
	@Pointcut("execution(* com.hotmarzz.oa.buzz..*.add*(..))||execution(* com.hotmarzz.oa.buzz..*.save*(..))||execution(* com.hotmarzz.oa.buzz..*.insert*(..))")
	public void saveOrInsertPointCut(){}
	
	@Pointcut("execution(* com.hotmarzz.oa.buzz..*.update*(..))")
	public void updatePointCut(){}
	
	@Before("saveOrInsertPointCut()")
	public void addMsgForSave(JoinPoint jp) throws Exception{
		Object emp = session.getAttribute(SessionUtils.LOGIN_EMP_KEY);
		String userName = null;
		if(emp!=null&&emp instanceof Emp){
			Emp loginEmp = (Emp) emp;
			userName = loginEmp.getUserName();
		}
		Object[] args = jp.getArgs();
		if(args!=null&&args.length>0){
			Object arg = args[0];
			if(arg instanceof Map){
				Map<String,Object> map = (Map<String, Object>) arg;
				map.put(CREATE_DATE, new Date());
				map.put(UPDATE_DATE, new Date());
				if(StringUtils.isNotEmpty(userName)){
					map.put(CREATE_USER, userName);
					map.put(UPDATE_USER, userName);
				}
			}else{
				BeanWrapper bw = new BeanWrapperImpl(arg);
				if(StringUtils.isNotEmpty(userName)){
					if(bw.isWritableProperty(CREATE_USER)){
						bw.setPropertyValue(CREATE_USER,userName);
					}
					if(bw.isWritableProperty(UPDATE_USER)){
						bw.setPropertyValue(UPDATE_USER,userName);
					}
				}
				if(bw.isWritableProperty(CREATE_DATE)){
					bw.setPropertyValue(CREATE_DATE, new Date());
				}
				if(bw.isWritableProperty(UPDATE_DATE)){
					bw.setPropertyValue(UPDATE_DATE,new Date());	
				}
			}
		}
	}
	
	@Before("updatePointCut()")
	public void addMsgForUpdate(JoinPoint jp) throws Exception{
		Object emp = session.getAttribute(SessionUtils.LOGIN_EMP_KEY);
		String userName = null;
		if(emp!=null&&emp instanceof Emp){
			Emp loginEmp = (Emp) emp;
			userName = loginEmp.getUserName();
		}
		Object[] args = jp.getArgs();
		if(args!=null&&args.length>0){
			Object arg = args[0];
			if(arg instanceof Map){
				Map<String,Object> map = (Map<String, Object>) arg;
				map.put(UPDATE_DATE, new Date());
				if(StringUtils.isNotEmpty(userName)){
					map.put(UPDATE_USER, userName);
				}
			}else{
				BeanWrapper bw = new BeanWrapperImpl(arg);
				if(StringUtils.isNotEmpty(userName)){
					if(bw.isWritableProperty(UPDATE_USER)){
						bw.setPropertyValue(UPDATE_USER,userName);
					}
				}
				if(bw.isWritableProperty(UPDATE_DATE)){
					bw.setPropertyValue(UPDATE_DATE,new Date());	
				}
			}
		}
		
	}
}
