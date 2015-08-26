package com.sssystem.edu.service.impl;

import java.util.HashMap;
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

	@Override
	public int selectLev(int ref_no) {
		int lev_no =  session.selectOne("category.selectLev", ref_no);
		return lev_no;
	}

	@Override
	public boolean selectNm(HashMap<String, Object> map) {
		int row = 0;
		row = session.selectOne("category.selectNm", map);
		if (row > 0) return true;
		return false;
	}

	@Override
	public boolean insert(CategoryVO bean) {
		int t = session.insert("category.insert", bean);
		if (t > 0) return true;
		return false;		
	}

	@Override
	public boolean delete(int category_no) {
		int t = session.delete("category.delete", category_no);
		if (t > 0) return true;
		return false;
	}

}
