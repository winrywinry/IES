package com.sssystem.edu.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QnaController {

	@Autowired
	QnaService qnaService;
	
	@RequestMapping("qna/list")
	public String listSelect(@RequestParam(value="board_gb")int board_gb){
		
		return "qna/list";
	}
}
