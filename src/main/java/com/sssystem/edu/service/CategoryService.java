package com.sssystem.edu.service;

import java.util.List;

import com.sssystem.edu.vo.CategoryVO;

public interface CategoryService {
	public List<CategoryVO> selectAll(int dept_no);
}
