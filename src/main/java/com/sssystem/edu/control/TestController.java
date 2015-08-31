package com.sssystem.edu.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping
	public String write(){
		return "test/write";
	}
}
