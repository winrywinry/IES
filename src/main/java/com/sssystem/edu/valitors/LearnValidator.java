package com.sssystem.edu.valitors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sssystem.edu.common.ValidateParamChk;
import com.sssystem.edu.vo.LearnVO;

public class LearnValidator implements Validator {

	@Autowired
	ValidateParamChk chk;
	
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object obj, Errors err) {
		LearnVO learnVO = (LearnVO) obj;
		if (chk.isEmpty(learnVO.getTitle())){
			err.rejectValue("title", "learn.title");
		}
	}

}
