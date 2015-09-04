package com.sssystem.edu.admin.control;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sssystem.edu.admin.service.AdminMemberService;
import com.sssystem.edu.admin.validators.MemberValidator;
import com.sssystem.edu.admin.vo.EmailVO;
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
  AdminMemberService adminMemberService;
  @Autowired
  DeptService deptService;
  @Autowired
  JobService jobService;
  @Autowired
  ValidateParamChk chk;

  @RequestMapping("/admin/member/list")
  public String list(
      @RequestParam(value = "searchWord", required = false) String searchWord,
      @RequestParam(value = "dept_no", required = false) String dn,
      @RequestParam(value = "job_no", required = false) String jn,
      @RequestParam(value = "page", required = false) String pn,
      @RequestParam(value = "manage_yn", required = false) String mn,
      @RequestParam(value = "admin_yn", required = false) String an, Model model) {
    PageVO pageVO = new PageVO();

    // ----------------------------------검색-------------------------------//
    if (mn != null) {
      mn = "1";
    } else {
      mn = "0";
    }
    if (an != null) {
      an = "1";
    } else {
      an = "0";
    }

    int dept_no = 0;
    int job_no = 0;
    int page = 1;
    int manage_yn = 0;
    int admin_yn = 0;
    if (!chk.isEmpty(dn))
      if (chk.isNumeric(dn))
        dept_no = chk.toInteger(dn);
    if (!chk.isEmpty(jn))
      if (chk.isNumeric(jn))
        job_no = chk.toInteger(jn);
    if (!chk.isEmpty(pn))
      if (chk.isNumeric(pn))
        page = chk.toInteger(pn);
    if (!chk.isEmpty(mn))
      if (chk.isNumeric(mn))
        manage_yn = chk.toInteger(mn);
    if (!chk.isEmpty(an))
      if (chk.isNumeric(an))
        admin_yn = chk.toInteger(an);

    if (!chk.isEmpty(searchWord))
      pageVO.setSearchWord(searchWord);
    if (dept_no != 0)
      pageVO.setDept_no(dept_no);
    if (job_no != 0)
      pageVO.setJob_no(job_no);
    if (page > 0)
      pageVO.setPage(page);
    pageVO.setManage_yn(manage_yn);
    pageVO.setAdmin_yn(admin_yn);

    int total = adminMemberService.selectTotal(pageVO);
    pageVO.setTotal(total);

    model.addAttribute("pageVO", pageVO);
    System.out.println(pageVO.toString());

    // ------------------------------부서,직책-----------------------------//
    List<DeptVO> deptlist = deptService.selectAll();
    List<JobVO> joblist = jobService.selectAll();

    model.addAttribute("deptlist", deptlist);
    model.addAttribute("joblist", joblist);

    // -------------------------------리스트 출력----------------------------//
    List<MemberVO> list = adminMemberService.selectAll(pageVO,
        pageVO.getPage());

    model.addAttribute("member", list);
    model.addAttribute("nowDate", new Date());

    return "admin/member/list";
  }

  // ---------------------------------------------------------------------------------------------------------------------------------------//
  @RequestMapping("/admin/member/writePage")
  public String writePage(MemberVO member,
      @RequestParam(value = "page", required = false) String spage,
      @RequestParam(value = "no", required = false) String no, Model model) {

    // --------------------------페이지값------------------------------//
    int page = 1;
    if (spage != null && spage.matches("\\d+")) {
      page = Integer.parseInt(spage);
    }

    // --------------------------유저넘버------------------------------//
    ValidateParamChk chk = new ValidateParamChk();
    int user_no = 0;
    if (!chk.isEmpty(no)) {
      if (chk.isNumeric(no)) {
        user_no = chk.toInteger(no);
      }
    }

    // --------------------------------------------------------//
    if (user_no > 0)
      member = adminMemberService.select(user_no);
    List<DeptVO> dept = adminMemberService.selectDept();
    List<JobVO> job = adminMemberService.selectJob();

    // --------------------------setAttribute------------------------------//
    model.addAttribute("member", member);
    model.addAttribute("dept", dept);
    model.addAttribute("job", job);
    model.addAttribute("nowDate", new Date());
    model.addAttribute("page", page);
    model.addAttribute("no", no);
    return "admin/member/write";
  }

  @RequestMapping("/admin/member/delete")
  public String Delete(
      @RequestParam(value="no", required=false)String sno
      ){
    int no = chk.toInteger(sno);

    adminMemberService.delete(no);
    return "redirect:list";
  }

  @Autowired
  MemberValidator memberVal;
  @Autowired
  EmailSender emailSender;
  
  @RequestMapping("/admin/member/writeAction")
  public String writeAction(@ModelAttribute("member") MemberVO memberVO,
                          HttpServletRequest request,
                          BindingResult result) throws Exception {
    memberVal.validate(memberVO, result);
    if (result.hasErrors()) return "redirect:writePage?msg=Confirm Input Data!!";
    
    //insert
      MultipartFile uploadfile = memberVO.getProfil();
      if (uploadfile != null) {
          String fileName = uploadfile.getOriginalFilename();
          memberVO.setProfil_picture(fileName);
          try {
              // 1. FileOutputStream 사용
              // byte[] fileData = file.getBytes();
              // FileOutputStream output = new FileOutputStream("C:/images/" + fileName);
              // output.write(fileData);
            
            ServletContext servletContext = request.getSession().getServletContext();
            String relativeWebPath = "/images/profil/"+ fileName;
            String absoluteDiskPath = servletContext.getRealPath(relativeWebPath);
            System.out.println(absoluteDiskPath);
              // 2. File 사용
              File file = new File(absoluteDiskPath);
              file.mkdir();
              uploadfile.transferTo(file);
          } catch (IOException e) {
              e.printStackTrace();
          } // try - catch
      } // if
      
      if(memberVO.getUser_no() > 0){
        adminMemberService.update(memberVO);
      }else{
      
        memberVO = adminMemberService.insert(memberVO);
        System.out.println(memberVO.getProfil_picture());
        
        System.out.println("name = " + memberVO.getUser_nm());
        System.out.println("email = " + memberVO.getEmail());
        System.out.println("number = " + memberVO.getEmp_serial());
        
        
        //----------이메일---------------------------------------------------------------------//
        EmailVO email = new EmailVO();
        
        String reciver = memberVO.getEmail();             //받을사람의 이메일입니다.
        String subject = memberVO.getUser_nm() + "님의 사원번호 입니다.";
        String content = getMailHTML(memberVO.getUser_nm(), memberVO.getEmp_serial());
         
        email.setReciver(reciver);
        email.setSubject(subject);
        email.setContent(content);
        emailSender.SendEmail(email);
      }//if
    
    return "redirect:list";
  }
  
  @RequestMapping("/admin/member/receive")
  public String receive(
      @RequestParam(value = "phone_no", required = false) String phone_no,
      @RequestParam(value = "birth", required = false) String birth,
      Model model     
      ){
    System.out.println("birth = "+birth);
    Date birth_dt;
    try {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      birth_dt = null;
      if (birth != null) birth_dt = sdf.parse(birth);
    
    System.out.println("birth_dt = " + birth_dt);
    
    MemberVO member = new MemberVO();
    member.setPhone_no(phone_no);
    member.setBirth_dt(birth_dt);
    
    
    int result = adminMemberService.selectDuple(member);
    model.addAttribute("result", result);
    model.addAttribute("phone_no", phone_no);
    model.addAttribute("birth", birth_dt);
    
    return "admin/member/receive";
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return "admin/member/receive";
  }
  
  public String getMailHTML(String name, String emp_serial){
	  String html = ""
	  + "<!DOCTYPE html>"
	  + "<html>"
	  + "<head>"
	  + "<meta charset=\"EUC-KR\">"
	  + "<title>사내교육시스템</title>"
	  + "<style type=\"text/css\">"
	  + "body { margin:0; padding:0;}"
	  + "#wrap { width:683px; border:1px solid #B5BCC8; }"
	  + "#con { padding:10px 0 20px 20px; }"
	  + "#con p { font:12px Dotum; color:#9FA8B9;}"
	  + "#con p.title { font:12px Dotum; color:#000; }"
	  + "#con em { font-weight:bold; font-style:normal; text-decoration:none;}"
	  + "#footer { height:50px; margin:0 auto; width:100%; padding:20px 0 0 0; text-align:center; font:11px Dotum; color:#FFF; background:#B5BCC8; }"
	  + "#footer p { margin:0; padding-bottom:5px; }"
	  + "#footer p.domain { font:11px Arial; font-weight:bold;}"
	  + "</style>"
	  + "</head>"
	  + "<body>"
	  + "<div id=\"wrap\">"
	  + "	<div><img src=\"http://192.168.7.55/IES/images/newmail_header_0.jpg\" width=\"683\" height=\"172\" alt=\"기압환영\" title=\"가입해 주셔서 감사합니다\" /></div>"
	  + "	<div id=\"con\">"
	  + "		<p class=\"title\"><em>"+ name +"</em>님 입사를 축하드립니다.</p>"
	  + "		<p>"
	  + "			"+ name +"님 안녕하세요?<br />"
	  + "			SSsystem에 가족이 되신 것을 축하드립니다.<br /><br />"
	  + "			귀하의 사원번호는 <em>"+ emp_serial +"</em>입니다.<br />"
	  + "			가족 여러분에게 좋은 서비스를 제공하기 위해 최선을 다하겠습니다.<br />"
	  + "			감사합니다.<br />"
	  + "		</p>"
	  + "	</div>"
	  + "	<div id=\"footer\">"
	  + "		<p>항상 여러분과 함께하는 SixSibling입니다.</p>"
	  + "		<p class=\"domain\">www.sssystem.com</p>"
	  + "	</div>"
	  + "</div>"
	  + "</body>"
	  + "</html>";
	  return html;
  }

}