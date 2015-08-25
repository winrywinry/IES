package com.sssystem.edu.service.impl;

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

}
