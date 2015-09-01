package com.sssystem.edu.valitors;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sssystem.edu.common.ValidateParamChk;
import com.sssystem.edu.vo.TestVO;

public class TestValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object obj, Errors err) {
		System.out.println("validate");
		TestVO testVO = (TestVO) obj;
		ValidateParamChk chk = new ValidateParamChk();
		
		if (chk.isEmpty(testVO.getTest())){
			testVO.setTest_no(0);
		} else {
			if (chk.isNumeric(testVO.getTest())){
				testVO.setTest_no(chk.toInteger(testVO.getTest()));
			}
		}
		if (chk.isEmpty(testVO.getEdu())){
			testVO.setEdu_no(0);
		} else {
			if (chk.isNumeric(testVO.getEdu())){
				testVO.setEdu_no(chk.toInteger(testVO.getEdu()));
			}
		}
		if (chk.isEmpty(testVO.getGubun())){
			err.rejectValue("gubun", "test.error.gubun");
		}
		if (chk.isEmpty(testVO.getQuestion())){
			err.rejectValue("question", "test.error.question");
		}
		if (testVO.getGubun().equals("A")){
			if (testVO.getAnswer_arr().length == 0){
				err.rejectValue("answer_nm", "test.error.answer_nm");
			} else {
				String answer_nm = "";
				for (String answer : testVO.getAnswer_arr()) {
					if (!answer_nm.equals("")) answer_nm += "@";
					answer_nm += answer;
				}
				testVO.setAnswer_nm(answer_nm);
				
			}
		} else {
			if (chk.isEmpty(testVO.getCorr_answer2())){
				err.rejectValue("corr_answer2", "test.error.corr_answer");
			} else {
				testVO.setAnswer_nm("");
				testVO.setCorr_answer(testVO.getCorr_answer2());
			}
		}
	}

}
