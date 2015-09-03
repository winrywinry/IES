package com.sssystem.edu.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.sssystem.edu.service.AuthService;
import com.sssystem.edu.vo.AuthVO;

public class AuthServiceImpl implements AuthService {
	@Autowired
	SqlSession session;
	
	@Override
	public boolean insert(AuthVO authVO) {
		int t = session.insert("auth.insert", authVO);
		if (t == 1) return true;
		return false;
	}

	@Override
	public boolean delete(int edu_no) {
		int t = session.delete("auth.delete", edu_no);
		if (t > 0) return true;
		return false;
	}

	@Override
	public List<AuthVO> select(int edu_no) {
		List<AuthVO> authlist = session.selectList("auth.select", edu_no);
		return authlist;
	}

}
