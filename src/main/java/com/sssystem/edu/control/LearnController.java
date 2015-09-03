package com.sssystem.edu.control;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sssystem.edu.common.ValidateParamChk;
import com.sssystem.edu.service.AuthService;
import com.sssystem.edu.service.CategoryService;
import com.sssystem.edu.service.DeptService;
import com.sssystem.edu.service.JobService;
import com.sssystem.edu.service.LearnSaveService;
import com.sssystem.edu.service.LearnService;
import com.sssystem.edu.service.TestService;
import com.sssystem.edu.valitors.LearnValidator;
import com.sssystem.edu.vo.AttachFileVO;
import com.sssystem.edu.vo.AuthVO;
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
	private DeptService deptService;
	@Autowired
	private JobService jobService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private TestService testService;
	@Autowired
	private LearnService learnService;
	@Resource(name="learnSaveService")
	private LearnSaveService learnSave;
	@Autowired
	private LearnValidator learnVal;
	@Autowired
	private ValidateParamChk chk;
	@Autowired
	private AuthService authService;
	
	@RequestMapping("/learn/write")
	public String write(@RequestParam(value="no", required=false) String no
			           , HttpSession session
			           , Model model){
		SessionVO sessionBean = (SessionVO) session.getAttribute("user");
		int dept_no = sessionBean.getDept_no();
		int user_no = sessionBean.getUser_no();
		int manage_yn = sessionBean.getManage_yn();
		
		int edu_no = 0;
		if (!chk.isEmpty(no)){
			if (chk.isNumeric(no)){
				edu_no = chk.toInteger(no);
			}
		}
		LearnVO learnVO = learnService.select(edu_no);
		List<AuthVO> authlist = authService.select(edu_no);
		
		List<DeptVO> deptlist = deptService.selectAll();
		List<JobVO> joblist = jobService.selectAll();
		List<CategoryVO> categorylist = categoryService.selectAll(dept_no);
		List<TestVO> testlist = testService.selectAll(0, user_no);
		
		model.addAttribute("deptlist", deptlist);
		model.addAttribute("joblist", joblist);
		model.addAttribute("categorylist", categorylist);
		model.addAttribute("testlist", testlist);
		model.addAttribute("learn", learnVO);
		
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
			          , BindingResult result
			          , DeptVO deptVO
			          , @RequestParam(value="job") String[] job
			          , AttachFileVO attachVO
			          , HttpServletRequest request
			          , HttpSession session
			          , Model model){
		learnVal.validate(learnVO, result);
		if (result.hasErrors()) return "test/write";
		
		SessionVO sessionBean = (SessionVO) session.getAttribute("user");
		int dept_no = sessionBean.getDept_no();
		int user_no = sessionBean.getUser_no();
		learnVO.setDept_no(dept_no);
		learnVO.setUser_no(user_no);
		
		System.out.println("learn/save");
		String job_str = "";
		for (int i=0;i<job.length;i++){
			job_str += "|"+ job[i];
		}
		if (!job_str.equals("")) job_str += "|";
		
		// Ã·ºÎÆÄÀÏ
		MultipartFile attach = attachVO.getAttach();
		String filename = attach.getOriginalFilename();
		attachVO.setAttach_file(filename);
		attachVO.setTable_nm("T_EDU_BOARD");
		
		ServletContext servletContext = request.getSession().getServletContext();
		String relativeWebPath = "/images/"+ filename;
		String absoluteDiskPath = servletContext.getRealPath(relativeWebPath);
		
		try {
			File file = new File(absoluteDiskPath);
			attach.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(learnVO.toString());
		try {
			learnSave.learnSave(learnVO, deptVO, job_str, attachVO);
		} catch (RuntimeException e) {
			 model.addAttribute("msg", e.getMessage());
			 return "learn/write";
		} catch (Exception e) {
			e.printStackTrace();
			return "learn/write";
		}
		
		return "redirect:list";
	}
	
}
