package com.sssystem.edu.valitors;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sssystem.edu.admin.vo.MemberVO;

public class JoinValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		System.out.println("supports()");
        //return false;
        return MemberVO.class.isAssignableFrom(clazz);

	}

	@Override
	public void validate(Object obj, Errors errors) {
		MemberVO memberVO = (MemberVO) obj;
		
		if(memberVO.getUser_nm().length()==0){
			System.out.println(memberVO.getUser_id());
			errors.rejectValue("user_nm", "reqqired", "기본메시지");
		}
		
		if(memberVO.getEmp_serial().length()==0){
			System.out.println(memberVO.getEmp_serial());
			errors.rejectValue("emp_serial", "asdsa");
		}
		
	}

}
