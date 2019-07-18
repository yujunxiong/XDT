package com.sell.admin.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class myHandlerInterceptor implements HandlerInterceptor {
	

	
	@Override
	public void afterCompletion(HttpServletRequest HttpRequest, HttpServletResponse Response, Object o, Exception e)
			throws Exception {
		

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	//在请求处理之前进行调用（Controller方法调用之前)
	@Override
	public boolean preHandle(HttpServletRequest HttpRequest, HttpServletResponse Response, Object o) throws Exception {
		String funcId = HttpRequest.getParameter("funcId");
		String uuid = HttpRequest.getParameter("uuid");
		if (uuid == null || funcId == null) {
		
			return false;
		}
		
		
		return true;
	}

}
