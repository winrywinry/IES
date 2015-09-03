package com.sssystem.edu.control;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sssystem.edu.service.LearnService;
import com.sssystem.edu.vo.DeptVO;
import com.sssystem.edu.vo.LearnVO;

@Controller
public class CommonController {
	
	@Autowired
	LearnService learnService;
	
	@RequestMapping("/include/header")
	public String includeHeader(){
		return "include/header";
	}

	@RequestMapping("/include/left_menu_learn")
	public String includeLeftLearn(Model model){
		
		List<DeptVO> list = learnService.selectLeftMenuList();
		model.addAttribute("list", list);
		for(int i = 0 ; i < list.size() ; i++){
			System.out.println(list.get(i));
		}
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
