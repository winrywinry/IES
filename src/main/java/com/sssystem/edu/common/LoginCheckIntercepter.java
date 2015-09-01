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
		HttpSession session = request.getSession();
		SessionVO user = (SessionVO) session.getAttribute("user");
		
		String reqUrl = request.getRequestURL().toString();
		reqUrl = reqUrl.replace("http://localhost/IES/", "");
		System.out.println("getURL="+ reqUrl);
		
		int cnt = 0;
		String[] passUrl = {"member", "css", "js", "images"};
		for (int i=0;i<passUrl.length;i++){
			if (reqUrl.startsWith(passUrl[i])){
				cnt++;
			}
		}
		if(cnt > 0){
		} else if (user == null) {
			response.sendRedirect("/IES/member/login");
			return false;
		}
		return super.preHandle(request, response, handler);
	}
	
}
