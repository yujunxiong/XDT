package com.sell.admin.HandlerInterceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sell.admin.service.impl.LoginServiceImpl;
import com.sell.util.CommonResult;

public class LoginHandlerInterceptor implements HandlerInterceptor {
	@Autowired
	private LoginServiceImpl loginService;

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest HttpRequest, HttpServletResponse HttpResponse, Object o) throws Exception {
		String funcId=HttpRequest.getParameter("funcId");
		String uuid=HttpRequest.getParameter("uuid");
		CommonResult result=new CommonResult();
		if(funcId==null || uuid==null) {
			result.setCode(201);
			result.failed("您还未登陆！");
			sendJsonMessage(HttpResponse,result);
			return false;
			
		}else {
			int num=loginService.check(uuid,Integer.parseInt(funcId));
			if(num==1) {
				return true;
			}else {
				result.setCode(201);
				result.failed("您没有权限！");
				sendJsonMessage(HttpResponse,result);
				return false;
			}
		}
	}
	
	// 将某个对象转换成json格式并发送到客户端
		public static void sendJsonMessage(HttpServletResponse response, Object obj)
				throws Exception {
			response.setContentType("application/json; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.print(JSONObject.toJSONString(obj,
					SerializerFeature.WriteMapNullValue,
					SerializerFeature.WriteDateUseDateFormat));
			writer.close();
			response.flushBuffer();
		}

}
