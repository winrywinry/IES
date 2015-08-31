package com.sssystem.edu.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sssystem.edu.vo.support.SessionVO;

public class LoginCheckIntercepter extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		//HttpSession session = request.getSession();
		//SessionVO user = (SessionVO) session.getAttribute("user");
		SessionVO user = new SessionVO(10, "À±¼ö¿¬", 7000, 40, 1, 1);
		request.getSession().setAttribute("user", user);
		System.out.println("Intercepter");
		
		if (user == null) {
			//response.sendRedirect("/");
			return false;
		}
		return super.preHandle(request, response, handler);
	}
	
}
