package com.sssystem.edu.control;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sssystem.edu.service.CategoryService;
import com.sssystem.edu.service.DeptService;
import com.sssystem.edu.service.JobService;
import com.sssystem.edu.service.TestService;
import com.sssystem.edu.vo.CategoryVO;
import com.sssystem.edu.vo.DeptVO;
import com.sssystem.edu.vo.JobVO;
import com.sssystem.edu.vo.TestVO;
import com.sssystem.edu.vo.support.SessionVO;

@Controller
public class LearnController {
	@Autowired
	DeptService deptService;
	@Autowired
	JobService jobService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	TestService testService;
	
	@RequestMapping("/learn/write")
	public String write(HttpSession session, Model model){
		SessionVO sessionBean = (SessionVO) session.getAttribute("user");
		int dept_no = sessionBean.getDept_no();
		int user_no = sessionBean.getUser_no();
		
		List<DeptVO> deptlist = deptService.selectAll();
		List<JobVO> joblist = jobService.selectAll();
		List<CategoryVO> categorylist = categoryService.selectAll(dept_no);
		List<TestVO> testlist = testService.selectAll(0, user_no);
		
		model.addAttribute("deptlist", deptlist);
		model.addAttribute("joblist", joblist);
		model.addAttribute("categorylist", categorylist);
		model.addAttribute("testlist", testlist);
		
		return "learn/write";
	}
}
