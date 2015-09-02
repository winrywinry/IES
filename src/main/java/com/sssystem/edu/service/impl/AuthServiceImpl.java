package com.sssystem.edu.service.impl;

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

}