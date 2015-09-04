package com.sssystem.edu.service;

import java.util.List;

import com.sssystem.edu.vo.AuthVO;

public interface AuthService {
	public boolean insert(AuthVO authVO);
	public boolean delete(int edu_no);
	public List<AuthVO> select(int edu_no);
}
