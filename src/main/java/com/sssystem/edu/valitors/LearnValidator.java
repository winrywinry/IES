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
		System.out.println("learnvalidator");
		LearnVO learnVO = (LearnVO) obj;
		if (chk.isEmpty(learnVO.getEdu())){
			learnVO.setEdu_no(0);
		} else {
			if (chk.isNumeric(learnVO.getEdu())){
				learnVO.setEdu_no(chk.toInteger(learnVO.getEdu()));
			} else {
				learnVO.setEdu_no(0);
			}
		}
		if (learnVO.getEssential_yn() != 1){
			learnVO.setEssential_yn(0);			
		}
		if (chk.isEmpty(learnVO.getTitle())){
			err.rejectValue("title", "learn.title");
		}
		if (learnVO.getCategory_no()<1){
			err.rejectValue("category_no", "learn.category_no");
		}
		if (chk.isEmpty(learnVO.getContents())){
			err.rejectValue("contents", "learn.contents");
		}
		if (chk.isEmpty(learnVO.getContents_tag())){
			learnVO.setContents_tag(" ");
		}
		if (chk.isEmpty(learnVO.getPeriod_st_str())){
			err.rejectValue("period_st", "learn.period_st");
		} else {
			if (chk.isDate(learnVO.getPeriod_st_str())){
				learnVO.setPeriod_st(chk.toDate(learnVO.getPeriod_st_str()));
			}
		}
		if (!chk.isEmpty(learnVO.getPeriod_ed_str())){
			if (chk.isDate(learnVO.getPeriod_ed_str())){
				learnVO.setPeriod_ed(chk.toDate(learnVO.getPeriod_ed_str()));
			}
		}
	}
}
