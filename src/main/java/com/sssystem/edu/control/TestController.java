package com.sssystem.edu.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sssystem.edu.common.ValidateParamChk;
import com.sssystem.edu.service.TestService;
import com.sssystem.edu.valitors.TestValidator;
import com.sssystem.edu.vo.TestVO;

@Controller
public class TestController {
	
	@Autowired
	ValidateParamChk chk;
	@Autowired
	TestService testService;
	@Autowired
	TestValidator testVal;

	@RequestMapping("/test/write")
	public String write(@RequestParam(value="edu", required=false) String edu
			           , @RequestParam(value="no", required=false) String no
			           , Model model){
		
		int edu_no = 0;
		int test_no = 0;
		if (!chk.isEmpty(edu)){
			if (chk.isNumeric(edu)){
				edu_no = chk.toInteger(edu);
			}
		}
		if (!chk.isEmpty(no)){
			if (chk.isNumeric(no)){
				test_no = chk.toInteger(no);
			}
		}
		
		if (test_no > 0) {
			TestVO testVO = testService.select(test_no);
			model.addAttribute("testVO", testVO);
		}
		model.addAttribute("edu_no", edu_no);
		model.addAttribute("test_no", test_no);

		return "test/write";
	}
	
	@RequestMapping("/test/save")
	public String save(@ModelAttribute("test") TestVO testVO
					  , BindingResult result
					  , Model model) {
		testVal.validate(testVO, result);
		if (result.hasErrors()) return "test/write";
		
		if (testVO.getTest_no() == 0) {
			//INSERT
			int test_no = testService.insert(testVO);
			if (test_no > 0){
				model.addAttribute("status", "insert");
				model.addAttribute("testBean", testService.select(test_no));
				return "test/result";
			} else {
				model.addAttribute("msg", "입력되지 않았습니다");
				return "test/write";
			}
		} else {
			//UPDATE
			if (testService.update(testVO)){
				TestVO newTestVO = testService.select(testVO.getTest_no());
				model.addAttribute("status", "update");
				model.addAttribute("testBean", newTestVO);
				return "test/result";
			} else {
				model.addAttribute("msg", "수정되지 않았습니다");
				return "test/write?";
			}
		}
	}
}
