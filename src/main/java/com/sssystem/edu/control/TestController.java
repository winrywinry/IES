package com.sssystem.edu.control;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.sssystem.edu.vo.support.SessionVO;

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
			model.addAttribute("testBean", testVO);
		}
		model.addAttribute("edu_no", edu_no);
		model.addAttribute("test_no", test_no);

		return "test/write";
	}
	
	@RequestMapping("/test/save")
	public String save(@ModelAttribute("test") TestVO testVO
					  , BindingResult result
					  , Model model
					  , HttpSession session) {
		SessionVO sessionBean = (SessionVO) session.getAttribute("user");
		int user_no = sessionBean.getUser_no();
		
		testVal.validate(testVO, result);
		if (result.hasErrors()) return "test/write";
		
		testVO.setUser_no(user_no);
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
	
	@RequestMapping("/test/delete")
	public String delete(@RequestParam(value="no") String no
			           , Model model){
		int test_no = 0;
		if (chk.isEmpty(no)){
			model.addAttribute("msg", "번호가 없습니다.");
		} else {
			if (chk.isNumeric(no)){
				test_no = chk.toInteger(no);
				TestVO testVO = testService.select(test_no);
				if (testService.delete(test_no)){
					model.addAttribute("testBean", testVO);
				} else {
					model.addAttribute("msg", "삭제되지 않았습니다.");
				}
			} else {
				model.addAttribute("msg", "숫자만 입력해 주세요.");
			}
		}
		model.addAttribute("status", "delete");
		return "test/result";
	}
	
	@RequestMapping("test/startTest")
	public String runTest(Model model,
			@RequestParam(value="edu_no")int edu_no){
		model.addAttribute("list",testService.selectTest(edu_no));
		return "test/startTest";
	}
	
	@RequestMapping("test/checkTest")
	public String checkTest(HttpServletRequest request,
			HttpSession session,
			Model model,
			@RequestParam(value="edu_no",required=false)int edu_no){
		int cntTest = testService.countTest(edu_no);
		System.out.println("cntTest ="+cntTest);
		for(int i = 1 ; i <= cntTest ; i++){
			System.out.println("i = "+i);
			TestVO testVO = testService.selectAnswer(88,i);
			String[] haha = request.getParameterValues(i+"");
			for(int b = 0; b < haha.length ; b++){
				if(testVO.getCorr_answer().equals(haha[b]))
				System.out.println("정답");
			}
		}
//		TestVO testVO = testService.selectAnswer(88,3);
//		System.out.println("gubun:"+testVO.getGubun());
//		System.out.println("corr_answer"+testVO.getCorr_answer());
		return "haha";
	}

}
