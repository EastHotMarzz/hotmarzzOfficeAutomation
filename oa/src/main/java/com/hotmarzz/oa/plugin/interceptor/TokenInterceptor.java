package com.hotmarzz.oa.plugin.interceptor;

import java.lang.reflect.Method;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hotmarzz.oa.anno.FormToken;
import com.hotmarzz.oa.utils.SessionUtils;

public class TokenInterceptor extends HandlerInterceptorAdapter{
	
	private Logger logger = LoggerFactory.getLogger(TokenInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug("in token intercetor ,还没执行handler");
		if (handler instanceof HandlerMethod) {  
            HandlerMethod handlerMethod = (HandlerMethod) handler;  
            Method method = handlerMethod.getMethod();  
            FormToken annotation = method.getAnnotation(FormToken.class);  
            if (annotation != null) {  
                boolean needSaveSession = annotation.save();  
                if (needSaveSession) {  
                    request.getSession(false).setAttribute(SessionUtils.FORM_TOKEN, UUID.randomUUID().toString());  
                }  
                boolean needRemoveSession = annotation.remove();  
                if (needRemoveSession) {  
                    if (isRepeatSubmit(request)) {  
                        return false;  
                    }  
                    request.getSession(false).removeAttribute(SessionUtils.FORM_TOKEN);  
                }  
            }  
            return true;  
        } else {  
        	return super.preHandle(request, response, handler);
        }  
		
	}
	
	private boolean isRepeatSubmit(HttpServletRequest request) {  
        String serverToken = (String) request.getSession(false).getAttribute(SessionUtils.FORM_TOKEN);  
        if (serverToken == null) {  
            return true;  
        }  
        String clinetToken = request.getParameter(SessionUtils.FORM_TOKEN);  
        if (clinetToken == null) {  
            return true;  
        }  
        if (!serverToken.equals(clinetToken)) {  
            return true;  
        }  
        return false;  
    } 

}
