package com.hotmarzz.oa.plugin.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hotmarzz.oa.controller.EmpController;
import com.hotmarzz.oa.pojo.Emp;
import com.hotmarzz.oa.utils.SessionUtils;

public class LoginInterceptor implements HandlerInterceptor{
	
	private Logger logger = LoggerFactory.getLogger(EmpController.class);
	
	@Override
	public void afterCompletion(HttpServletRequest req,
			HttpServletResponse resp, Object handler, Exception exception)
			throws Exception {
		logger.debug("视图已返回，执行afterCompletion()方法");
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp,
			Object handler, ModelAndView mav) throws Exception {
		logger.debug("controller已执行，得到mav对象，但是还没有返回视图");
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp,
			Object handler) throws Exception {
		logger.debug("还没执行handler");
		HttpSession se = req.getSession();
		Emp emp = (Emp) se.getAttribute(SessionUtils.LOGIN_EMP_KEY);
		String url = req.getRequestURI();
		if(emp != null){
			return true;
		}else{
			if(url.contains("login.do")){
				return true;
			}else{
				resp.sendRedirect("login.do");
				return false;
			}
		}
	}

}
