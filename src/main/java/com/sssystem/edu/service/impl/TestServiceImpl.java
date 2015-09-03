package com.sssystem.edu.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.sssystem.edu.service.TestService;
import com.sssystem.edu.vo.TestVO;

public class TestServiceImpl implements TestService {

	@Autowired
	SqlSession session;
	
	@Override
	public List<TestVO> selectAll(int edu_no, int user_no) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("edu_no", edu_no);
		map.put("user_no", user_no);
		
		return session.selectList("test.selectAll", map);
	}
	@Override
	public int insert(TestVO testVO) {
		session.insert("test.insert", testVO);
		int test_no = testVO.getTest_no();
		return test_no;
	}
	@Override
	public TestVO select(int test_no){
		TestVO testBean = session.selectOne("test.select", test_no);
		return testBean;
	}
	@Override
	public boolean update(TestVO testVO) {
		int t = session.update("test.update", testVO);
		if (t==1) return true;
		return false;
	}
	@Override
	public boolean delete(int test_no) {
		int t = session.delete("test.delete", test_no);
		if (t>0) return true;
		return false;
	}
	
	@Override
	public List<TestVO> selectTest(int edu_no) {
		List<TestVO> list = session.selectList("test.selectTest",edu_no);
		return list;
	}
	@Override
	public int countTest(int edu_no) {
		int t = session.selectOne("test.countTest",edu_no);
		return t;
	}
	@Override
	public TestVO selectAnswer(int edu_no, int q_no) {
		HashMap<String,Integer> input_map = new HashMap<String, Integer>();
		input_map.put("edu_no",edu_no);
		input_map.put("q_no",q_no);
		
		TestVO testVO = (TestVO) session.selectOne("test.selectAnswer",input_map);
		return testVO;
	}
	@Override
	public boolean eduInsert(int edu_no, int user_no) {
		HashMap<String, Object> info = new HashMap<String, Object>();
		info.put("edu_no", edu_no);
		info.put("user_no", user_no);
		int t = session.update("test.eduInsert", info);
		if (t > 0) return true;
		return false;
	}
}
