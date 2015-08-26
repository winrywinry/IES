package com.sssystem.edu.admin.control;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sssystem.edu.admin.service.AdminMemberService;
import com.sssystem.edu.admin.vo.MemberVO;
import com.sssystem.edu.admin.vo.PageVO;
import com.sssystem.edu.common.ValidateParamChk;
import com.sssystem.edu.service.DeptService;
import com.sssystem.edu.service.JobService;
import com.sssystem.edu.vo.DeptVO;
import com.sssystem.edu.vo.JobVO;

@Controller
public class AdminMemberController {
  
  @Autowired
  AdminMemberService adminMembeerService;
  @Autowired
  DeptService deptService;
  @Autowired
  JobService jobService;
  
  @RequestMapping("/admin/member/list")
  public String list(
      PageVO pageVO, 
      ValidateParamChk chk,
      @RequestParam(value="searchWord", required=false)String searchWord,
      @RequestParam(value="dept_no", required=false)String dn,
      @RequestParam(value="job_no", required=false)String jn,
      @RequestParam(value="page", required=false)String pn,
      @RequestParam(value="manage_yn", required=false)String mn,
      @RequestParam(value="admin_yn", required=false)String an,
      Model model){
    
    //----------------------------------검색-------------------------------//
    if(mn != null){ mn="1";}else{ mn="0";}
    if(an != null){ an="1";}else{ an="0";}
    
    int dept_no = 0;
    int job_no = 0;
    int page = 1;
    int manage_yn = 0;
    int admin_yn = 0;
    if(!chk.isEmpty(dn)) if(chk.isNumeric(dn)) dept_no = chk.toInteger(dn);
    if(!chk.isEmpty(jn)) if(chk.isNumeric(jn)) job_no = chk.toInteger(jn);
    if(!chk.isEmpty(pn)) if(chk.isNumeric(pn)) page = chk.toInteger(pn);
    if(!chk.isEmpty(mn)) if(chk.isNumeric(mn)) manage_yn = chk.toInteger(mn);
    if(!chk.isEmpty(an)) if(chk.isNumeric(an)) admin_yn = chk.toInteger(an);
    
    if(!chk.isEmpty(searchWord)) pageVO.setSearchWord(searchWord);
    if(dept_no != 0) pageVO.setDept_no(dept_no);
    if(job_no != 0) pageVO.setJob_no(job_no);
    if(page > 0) pageVO.setPage(page);
    pageVO.setManage_yn(manage_yn);
    pageVO.setAdmin_yn(admin_yn);
    
    
    int total = adminMembeerService.selectTotal(pageVO);
    pageVO.setTotal(total);
    
    model.addAttribute("pageVO", pageVO);
    
    //------------------------------부서,직책-----------------------------//
    List<DeptVO> deptlist = deptService.selectAll();
    List<JobVO> joblist = jobService.selectAll();
    
    model.addAttribute("deptlist",deptlist);
    model.addAttribute("joblist",joblist);
    
    //-------------------------------리스트 출력----------------------------//
    List<MemberVO> list = adminMembeerService.selectAll(pageVO, pageVO.getPage());
    
    model.addAttribute("member", list);
    model.addAttribute("nowDate", new Date());
    
    return "admin/member/list";
  }
  @RequestMapping("/admin/member/write")
  public String write(){
    return "admin/member/write";
  }

}
