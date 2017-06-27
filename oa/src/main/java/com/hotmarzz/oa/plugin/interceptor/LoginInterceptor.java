package com.hotmarzz.oa.plugin.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hotmarzz.oa.pojo.Emp;
import com.hotmarzz.oa.utils.SessionUtils;

public class LoginInterceptor implements HandlerInterceptor{
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public void afterCompletion(HttpServletRequest req,
			HttpServletResponse resp, Object handler, Exception exception)
			throws Exception {
		log.info("视图已返回，执行afterCompletion()方法");
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp,
			Object handler, ModelAndView mav) throws Exception {
		log.info("controller已执行，得到mav对象，但是还没有返回视图");
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp,
			Object handler) throws Exception {
		return true;
		/*log.info("还没执行handler");
		HttpSession se = req.getSession();
		Emp emp = (Emp) se.getAttribute(SessionUtils.LOGIN_EMP_KEY);
		String url = req.getRequestURI();
		if(emp != null){
			return true;
		}else{
			
			if(url.contains("userLogin.do") || url.contains("userOper.do")||url.contains("userRegister.do")){
				return true;
			}else{
				resp.sendRedirect("userOper.do");
				//req.getRequestDispatcher("/userOper.do").forward(req, resp);
				return false;
			}
		}*/
	}

}
