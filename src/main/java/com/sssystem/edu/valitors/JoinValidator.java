package com.sssystem.edu.valitors;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sssystem.edu.admin.vo.MemberVO;
import com.sssystem.edu.common.ValidateParamChk;

public class JoinValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object obj, Errors errors) {
		MemberVO memberVO = (MemberVO) obj;
		ValidateParamChk chk = new ValidateParamChk();
	
		System.out.println(memberVO.getUser_nm()+" / "+memberVO.getEmp_serial());
		
		if(chk.isEmpty(memberVO.getUser_nm())){
			errors.rejectValue("user_nm", "required", "이름을 정확히 입력하세요");
		}else if(chk.isNumeric(memberVO.getUser_nm())){
			errors.rejectValue("user_nm", "required", "이름을 정확히 입력하세요");	
		}else if(chk.isEmpty(memberVO.getEmp_serial())){
			errors.rejectValue("emp_serial", "required", "사원번호를 정확히 입력하세요");
		}else if(chk.isNumeric(memberVO.getEmp_serial())){
			errors.rejectValue("emp_serial", "required", "사원번호를 정확히 입력하세요");
		}

		
	}


}
