package com.sssystem.edu.control;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sssystem.edu.common.ValidateParamChk;
import com.sssystem.edu.service.CategoryService;
import com.sssystem.edu.service.DeptService;
import com.sssystem.edu.service.JobService;
import com.sssystem.edu.service.LearnService;
import com.sssystem.edu.service.TestService;
import com.sssystem.edu.vo.AttachFileVO;
import com.sssystem.edu.vo.CategoryVO;
import com.sssystem.edu.vo.DeptVO;
import com.sssystem.edu.vo.JobVO;
import com.sssystem.edu.vo.LearnVO;
import com.sssystem.edu.vo.TestVO;
import com.sssystem.edu.vo.search.SearchLearnVO;
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
		int dept_no = 0;
		int page_no = 1;
		SearchLearnVO pageVO = new SearchLearnVO();
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
		
	@RequestMapping("/learn/delete")
	public String delete(Model model,
			@RequestParam(value="edu_no")int edu_no){
		learnService.delete(edu_no);
		return "redirect:list";
	}
	
	@RequestMapping("/learn/save")
	public String save(@ModelAttribute("learn") LearnVO learnVO
			          , AttachFileVO attachVO
			          , HttpServletRequest request){
		MultipartFile attach = attachVO.getAttach();
		String filename = attach.getOriginalFilename();
		attachVO.setAttach_file(filename);
		
		try {
			learnSave();
		} catch {
			
		}
		
		ServletContext servletContext = request.getSession().getServletContext();
		String relativeWebPath = "/images/";
		String absoluteDiskPath = servletContext.getRealPath(relativeWebPath);
		return "";
	}
	
}
