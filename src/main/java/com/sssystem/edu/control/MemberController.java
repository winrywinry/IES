package com.sssystem.edu.control;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sssystem.edu.admin.vo.MemberVO;
import com.sssystem.edu.service.MemberService;
import com.sssystem.edu.valitors.JoinValidator;
import com.sssystem.edu.valitors.LoginValidator;
import com.sssystem.edu.valitors.PasswordFindValidator;
import com.sssystem.edu.vo.support.SessionVO;

@Controller
public class MemberController{
	
	@Autowired
	MemberService memberService;
	LoginValidator logvalidator;
	SessionVO sessionVO;
	JoinValidator joinvalidator;
	PasswordFindValidator findPassvalidator;
	

	@RequestMapping("/member/login")
	public String login(){
		return "member/login";
	}
	
	@RequestMapping("/member/index")
	public String index(Model model){
		
		int user_no = sessionVO.getUser_no();
		
		model.addAttribute(memberService.selectLogSession(user_no));
		model.addAttribute(memberService.selectWrite(user_no));
		model.addAttribute(memberService.selectQuestion(user_no));
		model.addAttribute(memberService.myWriteView(user_no));
		model.addAttribute(memberService.myQuestionView(user_no));
		
		
		return "index";
	}
	
	@RequestMapping("member/loginAccess")
	public String loginAccess(@RequestParam(value="user_id",required=false) String user_id,
							  @RequestParam(value="user_pwd",required=false) String user_pwd,
							  @ModelAttribute("member") MemberVO memberVO,
				  			  BindingResult result,
				  			  Model model){
		
		System.out.println("user_id: "+user_id);
		System.out.println("user_pwd: "+user_pwd);
		
		System.out.println("memberVO: " + memberVO);
		
		logvalidator.validate(memberVO, result);
		System.out.println("result: " + result);
		
		if(result.hasErrors()) {
			System.out.println("LoginErrors");
			return "member/login";
		}
		
		if(memberService.selectLogin(user_id)==null) {
			model.addAttribute("msg", "입력 정보를 정확히 입력하세요");
			return "member/login";
		}
		
		if(memberService.selectLogin(user_id).equals(user_pwd)){
		SessionVO sessionVO = memberService.selectSession(user_id);
		System.out.println("sessionVO: " +sessionVO);
		model.addAttribute("user", sessionVO);
		return "redirect:index";
		}
		else {
			model.addAttribute("msg", "입력 정보를 정확히 입력하세요");
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
		
		System.out.println("memberVO: " + memberVO);
		
		joinvalidator.validate(memberVO, result);
		
		if(result.hasErrors()) {
			System.out.println("JoinErrors");
			return "member/join_check";
		}
		
		else if(memberService.selectEmp(user_nm, emp_serial)==null) {
			model.addAttribute("msg", "입력 정보를 정확히 입력하세요");
			return "member/join_check";
		}
		
		else if(memberService.selectEmp(user_nm, emp_serial).equals(user_nm)){
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("user_nm", user_nm);
			map.put("emp_serial", emp_serial);
			
			System.out.println(user_nm);
			System.out.println(emp_serial);
			
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
							 @RequestParam(value="line_no",required=false) String line_no,
							 @RequestParam(value="phone",required=false) String phone_no,
							 @RequestParam(value="second",required=false) String second_no,
							 @RequestParam(value="post",required=false) String post,
							 @RequestParam(value="address",required=false) String address,
							 @RequestParam(value="email",required=false) String email,
							 Model model){
		
		MemberVO memberVO = new MemberVO();
		 int result = memberService.selectID(user_id);

		 
		memberVO.setUser_no(user_no);
		memberVO.setUser_id(user_id);
		memberVO.setUser_pwd(user_pwd);
		memberVO.setLine_no(line_no);
		memberVO.setPhone_no(phone_no);
		memberVO.setSecond_no(second_no);
		memberVO.setPost(post);
		memberVO.setAddress(address);
		memberVO.setEmail(email);
		
		
		if(memberService.updateJoin(memberVO)){
		
			return "member/login";
			}
		else 
		return "member/join_check";
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
			model.addAttribute("msg", "입력 정보를 정확히 입력하세요");
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
						  	    BindingResult result, Model model){
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
			model.addAttribute("msg", "입력 정보를 정확히 입력하세요");
			return "/member/search_pass";
		}
		
		else if(memberService.selectEmp2(map).equals(user_nm)){
			
			HashMap<String, Object> deptjob = memberService.selectDept(map);
		int user_no = Integer.valueOf(String.valueOf(deptjob.get("USER_NO")));
		MemberVO memverVO = memberService.select(user_no);
		model.addAttribute("member", memverVO);
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
}

















