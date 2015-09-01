package com.sssystem.edu.control;

import java.sql.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sssystem.edu.common.ValidateParamChk;
import com.sssystem.edu.service.CompleteService;
import com.sssystem.edu.service.LearnService;
import com.sssystem.edu.vo.CompleteVO;
import com.sssystem.edu.vo.LearnVO;
import com.sssystem.edu.vo.search.SearchLearnVO;
import com.sssystem.edu.vo.support.SessionVO;

@Controller
public class CompleteController {
	
	@Autowired
	LearnService learnService;
	
	@Autowired
	CompleteService completeService;
	
	@RequestMapping("/learn/contentsView")
	public String contentsView(HttpSession session, Model model,
			@RequestParam(value="searchWord",required=false)String searchWord,
			@RequestParam(value="dept_no")String dn,
			@RequestParam(value="page")String pn,
			@RequestParam(value="no")int no){
		
		ValidateParamChk chk = new ValidateParamChk();
		SearchLearnVO pageVO = new SearchLearnVO();
		SessionVO sessionVO = (SessionVO) session.getAttribute("user");
		
		
		int dept_no = 0;
		int page_no = 1;
		
		if(!chk.isEmpty(dn)) if(chk.isNumeric(dn)) dept_no = chk.toInteger(dn);
		if(!chk.isEmpty(pn)) if(chk.isNumeric(pn)) page_no = chk.toInteger(pn);
		
		if(!chk.isEmpty(searchWord)) pageVO.setSearchWord(searchWord);
		if(dept_no != 0) pageVO.setDept_no(dept_no);
		if(dept_no > 0) pageVO.setPage_no(page_no);
		
		pageVO.setSeq_no(no);
		
		learnService.updateViewCnt(no);
		
		LearnVO learn = learnService.select(no);
		LearnVO learnNext = learnService.selectNext(pageVO);
		LearnVO learnPrev = learnService.selectPrev(pageVO);
		CompleteVO learnComplete = completeService.selectComplete(no,sessionVO.getUser_no());
		
		model.addAttribute("learn",learn);
		model.addAttribute("learnNext",learnNext);
		model.addAttribute("learnPrev",learnPrev);
		model.addAttribute("learnComplete",learnComplete);
		
		return "learn/view";
	}
	
	
	
	@RequestMapping("learn/updateComplete")
	public String updateComplete(HttpSession session, Model model,
			@RequestParam(value="no")int edu_no,
			@RequestParam(value="start_dt",required=false,defaultValue="1111-11-11")Date start_dt,
			@RequestParam(value="end_dt",required=false,defaultValue="1111-11-11")Date end_dt){
		
		SessionVO sessionVO = (SessionVO) session.getAttribute("user");
		CompleteVO completeVO = new CompleteVO();
		completeVO.setEdu_no(edu_no);
		completeVO.setUser_no(sessionVO.getUser_no());
		completeVO.setStart_dt(start_dt);
		completeVO.setEnd_dt(end_dt);
		
		if(start_dt.equals("1111-11-11")){
			if(completeService.insertComplete(completeVO)) return "learn/view";
		}else{
			if(completeService.updateComplete(completeVO)){
				return "learn/view";			
			}
		}
		
		return "learn/list";
	}

}