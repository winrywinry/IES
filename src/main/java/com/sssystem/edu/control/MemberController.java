package com.sssystem.edu.control;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sssystem.edu.vo.MemberVO;
import com.sssystem.edu.admin.control.EmailSender;
import com.sssystem.edu.admin.vo.EmailVO;
import com.sssystem.edu.service.BoardService;
import com.sssystem.edu.service.CompleteService;
import com.sssystem.edu.service.MemberService;
import com.sssystem.edu.service.QnaService;
import com.sssystem.edu.valitors.JoinValidator;
import com.sssystem.edu.valitors.LoginValidator;
import com.sssystem.edu.valitors.PasswordFindValidator;
import com.sssystem.edu.vo.support.SessionVO;

@Controller
public class MemberController{
	
	@Autowired
	MemberService memberService;
	@Autowired
	LoginValidator logvalidator;
	@Autowired
	SessionVO sessionVO;
	@Autowired
	JoinValidator joinvalidator;
	@Autowired
	PasswordFindValidator findPassvalidator;
	@Autowired
	MemberVO memberVO;
	@Autowired
	QnaService qna;
	@Autowired
	BoardService board;
	@Autowired
	CompleteService completesService;
	@Autowired
	EmailSender emailSender;
	

	@RequestMapping("/member/login")
	public String login(){
		return "member/login";
	}
	
	@RequestMapping("index")
	public String index(Model model, HttpSession session){
		
		session.setAttribute("user", sessionVO);
		
		int user_no = sessionVO.getUser_no();
		model.addAttribute("photo", memberService.photo(user_no));
		
		model.addAttribute("log", memberService.selectLogSession(user_no));//출석수
		model.addAttribute("write", memberService.selectWrite(user_no));//게시글수
		model.addAttribute("question", memberService.selectQuestion(user_no));//질문수
		
		model.addAttribute("myWriteView", memberService.myWriteView(user_no));//나의질문
		model.addAttribute("myQuestionView", memberService.myQuestionView(user_no));//나의게시글
		
		model.addAttribute("recommendView", qna.recommendView());//메인화면 건의사항view
		
		model.addAttribute("notice", board.notice());//메인화면 공지사항 view
		model.addAttribute("reply", board.selectReply(user_no)); //댓글수
		model.addAttribute("replyContents", board.replyContents(user_no));//댓글view
		
		model.addAttribute("completes", completesService.myLearn(user_no));//이수예정
		System.out.println(completesService.myLearn(user_no));
		model.addAttribute("completes2", completesService.myLearn2(user_no));//최근이수
		System.out.println(completesService.myLearn2(user_no));
		
		model.addAttribute("learnCount", completesService.learnCount(user_no));//이수예정count
		model.addAttribute("learnCount2", completesService.learnCount2(user_no));//최근이수count
		
		return "index";
	}
	
	@RequestMapping("member/loginAccess")
	public String loginAccess(@RequestParam(value="user_id",required=false) String user_id,
							  @RequestParam(value="user_pwd",required=false) String user_pwd,
							  @ModelAttribute("member") MemberVO memberVO,
				  			  BindingResult result,
				  			  Model model,
				  			  HttpSession session){
		
		logvalidator.validate(memberVO, result);
		System.out.println("result: " + result);
		
		if(result.hasErrors()) {
			System.out.println("LoginErrors");
			return "member/login";
		}
		
		if(memberService.selectLogin(user_id)==null) {
			model.addAttribute("msg", "존재하지 않는 아이디이거나 비밀번호가 일치하지 않습니다.");
			return "member/login";
		}
		
		if(memberService.selectLogin(user_id).equals(user_pwd)){
		sessionVO = memberService.selectSession(user_id);
		int user_no = sessionVO.getUser_no();
		memberService.insertLog(user_no);
		
		session.setAttribute("user", sessionVO);
		System.out.println("user:"+session.getAttribute("user"));
		return "redirect:/index";
		}
		else {
			model.addAttribute("msg", "잘못된 사원이름이거나 잘못된 사원번호 입니다");
			return "member/login";
		}
	}//loginAccess
	
	@RequestMapping("/member/joinCheck")
	public String joinCheck(){
		return "member/join_check";
	}//joinCheck
	
	@RequestMapping("/member/joinAccess")
	public String joinAccess(@RequestParam(value="user_nm",required=false) String user_nm,
			  				 @RequestParam(value="emp_serial",required=false) String emp_serial,
			  				 @ModelAttribute("comm") MemberVO memberVO,
			  				 BindingResult result,
			  				 Model model){
		
		joinvalidator.validate(memberVO, result);
		
		if(result.hasErrors()) {
			System.out.println("JoinErrors");
			return "member/join_check";
		}
		
		else if(memberService.selectEmp(user_nm, emp_serial)==null) {
			model.addAttribute("msg", "이미 가입되었거나 검색되지 않은 사원번호 입니다");
			return "member/join_check";
		}
		
		else if(memberService.selectEmp(user_nm, emp_serial).equals(user_nm)){
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("user_nm", user_nm);
			map.put("emp_serial", emp_serial);
			
			HashMap<String, Object> deptjob = memberService.selectDept1(map);
			int user_no = Integer.valueOf(String.valueOf(deptjob.get("USER_NO")));
			MemberVO memverVO = memberService.select(user_no);
			model.addAttribute("deptjob", deptjob);
			model.addAttribute("member", memverVO);
			
			return "member/join";
		}
		else return "member/join_check";
	}//joinAccess
	
	@RequestMapping("member/joinAction")
	public String joinAction(@RequestParam(value="user_no",required=false) int user_no,
							 @RequestParam(value="user_id",required=false) String user_id,
							 @RequestParam(value="user_pwd",required=false) String user_pwd,
							 @RequestParam(value="line_no1",required=false) String line_no1,
							 @RequestParam(value="line_no2",required=false) String line_no2,
							 @RequestParam(value="line_no3",required=false) String line_no3,
							 @RequestParam(value="phone_no1",required=false) String phone_no1,
							 @RequestParam(value="phone_no2",required=false) String phone_no2,
							 @RequestParam(value="phone_no3",required=false) String phone_no3,
							 @RequestParam(value="second_no1",required=false) String second_no1,
							 @RequestParam(value="second_no2",required=false) String second_no2,
							 @RequestParam(value="second_no3",required=false) String second_no3,
							 @RequestParam(value="post",required=false) String post,
							 @RequestParam(value="address",required=false) String address,
							 @RequestParam(value="email1",required=false) String email1,
							 @RequestParam(value="email2",required=false) String email2,
							 Model model){
		
		String line_no = line_no1+"-"+line_no2+"-"+line_no3;
		String phone_no = phone_no1+"-"+phone_no2+"-"+phone_no3;
		String second_no = second_no1+"-"+second_no2+"-"+second_no3;
		String email = email1+email2;
		
		memberVO.setUser_id(user_id);
		memberVO.setUser_pwd(user_pwd);
		memberVO.setLine_no(line_no);
		memberVO.setPhone_no(phone_no);
		memberVO.setSecond_no(second_no);
		memberVO.setPost(post);
		memberVO.setAddress(address);
		memberVO.setEmail(email);
		memberVO.setUser_no(user_no);
		
		
		if(memberService.updateJoin(memberVO)) return "member/login";
		
		else return "member/join_check";
		
		}
		
		
	
	@RequestMapping("/member/findIdCheck")
	public String findIdCheck(){
		return "member/search_id";
	}//findIdCheck
	
	
	@RequestMapping("/member/findIdCheckAccess")
	public String findIdCheckAccess(@RequestParam(value="user_nm",required=false) String user_nm,
							  	    @RequestParam(value="emp_serial",required=false) String emp_serial,
							  	    @ModelAttribute("comm") MemberVO memberVO,
							  	    BindingResult result,
							  	    Model model){
		
		joinvalidator.validate(memberVO, result);
		
		if(result.hasErrors()) {
			System.out.println("FindIdErrors");
			return "/member/search_id";
		}
		
		else if(memberService.selectEmp1(user_nm, emp_serial)==null){
			model.addAttribute("msg", "잘못된 사원이름이거나 잘못된 사원번호 입니다");
			return "/member/search_id";
		}
		
		else if(memberService.selectEmp1(user_nm, emp_serial).equals(user_nm)){
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("user_nm", user_nm);
			map.put("emp_serial", emp_serial);
			
			HashMap<String, Object> deptjob = memberService.selectDept(map);
			int user_no = Integer.valueOf(String.valueOf(deptjob.get("USER_NO")));
			MemberVO memverVO = memberService.select(user_no);
			String id = memverVO.getUser_id().substring(0,memverVO.getUser_id().length()-4)+"****";
			model.addAttribute("user_nm", user_nm);
			model.addAttribute("id", id);
			return "member/search_id_ok";
		}
		else 
		return "redirect:findIdCheck";
	}//findIdCheckAccess
	
	@RequestMapping("/member/findPasswordCheck")
	public String findPasswordCheck(){
		return "member/search_pass";
	}//findPasswordCheck
	
	@RequestMapping("/member/findPasswordAccess")
	public String findPassword(@RequestParam(value="user_id",required=false) String user_id,
							   @RequestParam(value="user_nm",required=false) String user_nm,
	  	    				   @RequestParam(value="emp_serial",required=false) String emp_serial,
	  	    				   @ModelAttribute("comm") MemberVO memberVO,
						  	    BindingResult result, Model model) throws Exception{
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("user_id", user_id);
		map.put("user_nm", user_nm);
		map.put("emp_serial", emp_serial);
		
		findPassvalidator.validate(memberVO, result);
		
		if(result.hasErrors()) {
			System.out.println("FindPasswordErrors");
			return "redirect:findPasswordCheck";
		}
		
		else if(memberService.selectEmp2(map)==null){
			model.addAttribute("msg", "잘못된 사원이름이거나 잘못된 사원번호 입니다");
			return "/member/search_pass";
		}
		
		else if(memberService.selectEmp2(map).equals(user_nm)){
			
			HashMap<String, Object> deptjob = memberService.selectDept(map);
		int user_no = Integer.valueOf(String.valueOf(deptjob.get("USER_NO")));
		System.out.println(user_no);
		MemberVO member = memberService.select(user_no);
		model.addAttribute("member", member);
		
		  EmailVO email = new EmailVO();
	        
      String reciver = member.getEmail();             //받을사람의 이메일입니다.
      String subject = member.getUser_nm() + "님의 비밀번호 입니다.";
      String content = "당신의 비밀번호는 [" + member.getUser_pwd()+ "] 입니다.";
       
      email.setReciver(reciver);
      email.setSubject(subject);
      email.setContent(content);
      emailSender.SendEmail(email);
//      System.out.println("번호 = " + member.getUser_no());
//      System.out.println("메일 = " + member.getEmail());
//      System.out.println("이름 = " + member.getUser_nm());
//      System.out.println("비번 = " + member.getUser_pwd());
		
		return "member/search_pass_ok";
		}
		else return "redirect:findPasswordCheck";
	}//findPassword
	
	@RequestMapping("/member/idCheck")
	public String idCheck(@RequestParam(value="id") String id
			            , Model model){
		int result = memberService.selectID(id);
		String val = "";
		if (result == 0) {
			val = "success";
			model.addAttribute("msg", "사용 가능한 아이디 입니다");
		} else {
			val = "fail";
			model.addAttribute("msg", "중복된 아이디입니다");
		}
		model.addAttribute("val", val);
		model.addAttribute("id", id);
		return "member/idCheck";
	}
	
	@RequestMapping("/calendar")
	public String calendar(Model model){
		model.addAttribute("cal", completesService.cal());
		return "/calendar";
	}
	
}

















