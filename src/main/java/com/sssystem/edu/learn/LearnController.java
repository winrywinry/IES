package com.sssystem.edu.learn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sssystem.edu.dept.DeptService;
import com.sssystem.edu.dept.DeptVO;
import com.sssystem.edu.job.JobService;
import com.sssystem.edu.job.JobVO;

@Controller
public class LearnController {
	@Autowired
	DeptService deptService;
	@Autowired
	JobService jobService;
	
	@RequestMapping("/learn/write")
	public String write(Model model){
		List<DeptVO> deptlist = deptService.selectAll();
		List<JobVO> joblist = jobService.selectAll();
		model.addAttribute("deptlist", deptlist);
		return "learn/write";
	}
}
