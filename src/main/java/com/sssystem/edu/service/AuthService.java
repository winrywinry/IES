package com.sssystem.edu.service;

import com.sssystem.edu.vo.AuthVO;

public interface AuthService {
	public boolean insert(AuthVO authVO);
	public boolean delete(int edu_no);
}
