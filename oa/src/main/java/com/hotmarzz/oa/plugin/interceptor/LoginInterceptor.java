package com.hotmarzz.oa.plugin.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hotmarzz.oa.pojo.Emp;
import com.hotmarzz.oa.utils.SessionUtils;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		logger.debug("in login intercetor ,还没执行handler");
		HttpSession se = request.getSession();
		Emp emp = (Emp) se.getAttribute(SessionUtils.LOGIN_EMP_KEY);
		String url = request.getRequestURI();
		if(emp != null){
			return true;
		}else{
			if(url.contains("login.do")){
				return true;
			}else{
				response.sendRedirect("login.do");
				return false;
			}
		}
	}

}
