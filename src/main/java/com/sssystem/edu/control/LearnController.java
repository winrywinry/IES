package com.sssystem.edu.control;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sssystem.edu.admin.vo.PageVO;
import com.sssystem.edu.common.ValidateParamChk;
import com.sssystem.edu.service.CategoryService;
import com.sssystem.edu.service.DeptService;
import com.sssystem.edu.service.JobService;
import com.sssystem.edu.service.LearnService;
import com.sssystem.edu.service.TestService;
import com.sssystem.edu.vo.CategoryVO;
import com.sssystem.edu.vo.DeptVO;
import com.sssystem.edu.vo.JobVO;
import com.sssystem.edu.vo.LearnVO;
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
	@Autowired
	LearnService learnService;
	
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
	
	@RequestMapping("/learn/list")
	public String list(Model model,
			@RequestParam(value="dept_no", required=false)String dn,
			@RequestParam(value="page", required=false)String pn,
			@RequestParam(value="searchWord", required=false)String searchWord
			){
		System.out.println("dept_no = "+dn+" page = "+pn+" searchWord = "+searchWord);
		int dept_no = 0;
		int page_no = 1;
		PageVO pageVO = new PageVO();
		ValidateParamChk chk = new ValidateParamChk();
		if(!chk.isEmpty(dn)) if(chk.isNumeric(dn)) dept_no = chk.toInteger(dn);
		if(!chk.isEmpty(pn)) if(chk.isNumeric(pn)) page_no = chk.toInteger(pn);
		
		if(!chk.isEmpty(searchWord)) pageVO.setSearchWord(searchWord);
		if(dept_no != 0) pageVO.setDept_no(dept_no);
		if(page_no > 0) pageVO.setPage_no(page_no);
		
		int total = learnService.selectCnt(pageVO);
		pageVO.setTotal(total);
		
		List<LearnVO> list = learnService.selectAll(pageVO,page_no);
		model.addAttribute("list",list);
		model.addAttribute("pageBean",pageVO);
		
		return "learn/list";
	}
	
	@RequestMapping("/learn/contentsView")
	public String contentsView(Model model,
			@RequestParam(value="searchWord",required=false)String searchWord,
			@RequestParam(value="dept_no")String dn,
			@RequestParam(value="page")String pn,
			@RequestParam(value="no")int no){
		
		ValidateParamChk chk = new ValidateParamChk();
		PageVO pageVO = new PageVO();
		
		int dept_no = 0;
		int page_no = 1;
		
		if(!chk.isEmpty(dn)) if(chk.isNumeric(dn)) dept_no = chk.toInteger(dn);
		if(!chk.isEmpty(pn)) if(chk.isNumeric(pn)) page_no = chk.toInteger(pn);
		
		if(!chk.isEmpty(searchWord)) pageVO.setSearchWord(searchWord);
		if(dept_no != 0) pageVO.setDept_no(dept_no);
		if(dept_no > 0) pageVO.setPage_no(page_no);
		
		pageVO.setSeq_no(no);
		
		learnService.updateViewCnt(no);
			
		System.out.println("seq_no= "+no+" dept_no = "+dept_no+" searchWord = "+searchWord);
		
		LearnVO learn = learnService.select(no);
		LearnVO learnNext = learnService.selectNext(pageVO);
		LearnVO learnPrev = learnService.selectPrev(pageVO);
		
		model.addAttribute("learn",learn);
		model.addAttribute("learnNext",learnNext);
		model.addAttribute("learnPrev",learnPrev);
		
		return "learn/view";
	}
	
	@RequestMapping("learn/delete")
	public String delete(Model model,
			@RequestParam(value="edu_no")int edu_no){
		learnService.delete(edu_no);
		return "redirect:list";
	}
	
}
