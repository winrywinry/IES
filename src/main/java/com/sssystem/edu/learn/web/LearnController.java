package com.sssystem.edu.learn.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sssystem.edu.dept.service.DeptService;
import com.sssystem.edu.dept.service.DeptVO;

@Controller
public class LearnController {
	@Autowired
	DeptService deptService;
	
	@RequestMapping("/learn/write")
	public String write(Model model){
		List<DeptVO> deptlist = deptService.selectAll();
		model.addAttribute("deptlist", deptlist);
		return "learn/write";
	}
}
