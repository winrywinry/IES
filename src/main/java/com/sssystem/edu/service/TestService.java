package com.sssystem.edu.service;

import java.util.List;

import com.sssystem.edu.vo.TestVO;

public interface TestService {
	public List<TestVO> selectAll(int edu_no, int user_no);
	public TestVO select(int test_no);
	public int insert(TestVO testVO);
	public boolean update(TestVO testVO);
	public boolean delete(int test_no);
	public List<TestVO> selectTest(int edu_no);
}
