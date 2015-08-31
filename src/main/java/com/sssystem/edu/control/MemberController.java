package com.sssystem.edu.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	@RequestMapping("/member/login")
	public String login(){
		return "member/login";
	}
	
	@RequestMapping("/member/joinCheck")
	public String joinCheck(){
		return "member/join_check";
	}//joinCheck
}
