package com.sssystem.edu.valitors;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sssystem.edu.admin.vo.MemberVO;
import com.sssystem.edu.common.ValidateParamChk;

public class LoginValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object obj, Errors errors) {
		MemberVO memberVO = (MemberVO) obj;
		ValidateParamChk chk = new ValidateParamChk();
		
		System.out.println(memberVO.getUser_id()+" / " + memberVO.getUser_pwd());
		
		if(chk.isEmpty(memberVO.getUser_id())||chk.isNumeric(memberVO.getUser_id())){
			errors.rejectValue("user_id", "required", "이름을 정확히 입력하세요");	
		}
		
		if(chk.isEmpty(memberVO.getUser_pwd())||chk.isNumeric(memberVO.getUser_pwd())){
			errors.rejectValue("user_pwd", "required", "비밀번호를 정확히 입력하세요");
		}
		
	}

}
