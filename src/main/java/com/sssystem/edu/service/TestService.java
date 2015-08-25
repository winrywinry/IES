package com.sssystem.edu.service;

import java.util.List;

import com.sssystem.edu.vo.TestVO;

public interface TestService {
	
	public List<TestVO> selectAll(int edu_no, int user_no);
}
