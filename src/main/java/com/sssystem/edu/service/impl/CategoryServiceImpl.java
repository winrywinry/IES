package com.sssystem.edu.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.sssystem.edu.service.CategoryService;
import com.sssystem.edu.vo.CategoryVO;

public class CategoryServiceImpl implements CategoryService {

	@Autowired
	SqlSession session;
	
	@Override
	public List<CategoryVO> selectAll(int dept_no) {
		return session.selectList("category.selectAll", dept_no);
	}

}
