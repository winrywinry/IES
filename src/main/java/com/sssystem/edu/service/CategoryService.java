package com.sssystem.edu.service;

import java.util.HashMap;
import java.util.List;

import com.sssystem.edu.vo.CategoryVO;

public interface CategoryService {
	public List<CategoryVO> selectAll(int dept_no);
	public int selectLev(int ref_no);
	public boolean selectNm(HashMap<String, Object> map);
	public boolean insert(CategoryVO bean);
	public boolean delete(int category_no);
}
