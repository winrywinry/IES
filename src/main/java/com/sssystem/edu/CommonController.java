package com.sssystem.edu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {
	
	@RequestMapping("/include/header")
	public String includeHeader(){
		return "include/header";
	}

	@RequestMapping("/include/left_menu_learn")
	public String includeLeftLearn(){
		return "include/left_menu_learn";
	}
	
	@RequestMapping("/include/left_menu_community")
	public String includeLeftCommunity(){
		return "include/left_menu_community";
	}
	
	@RequestMapping("/include/footer")
	public String includeFooter(){
		return "include/footer";
	}
	
	@RequestMapping("/include/left_menu_info")
	public String includeLeftInfo(){
		return "include/left_menu_info";
	}
	
	@RequestMapping("/include/left_menu_propose")
	public String includeLeftPropose(){
		return "include/left_menu_propose";
	}
	
	@RequestMapping("LOGOUT")
	public String Logout(){
		return "redirect:member/login";
	}
}
