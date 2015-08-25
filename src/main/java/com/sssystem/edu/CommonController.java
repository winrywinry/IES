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
	
	@RequestMapping("/include/footer")
	public String includeFooter(){
		return "include/footer";
	}
}
