package com.sssystem.edu.service;

import java.util.HashMap;
import java.util.List;

import com.sssystem.edu.admin.vo.PageVO;
import com.sssystem.edu.vo.DeptVO;
import com.sssystem.edu.vo.LearnVO;
import com.sssystem.edu.vo.search.SearchLearnVO;

public interface LearnService {
	public List<LearnVO> selectAll(SearchLearnVO pageVO, int page);
	public int selectCnt(SearchLearnVO pageVO);
	public void updateViewCnt(int no);
	public LearnVO select(int no);
	public LearnVO selectNext(SearchLearnVO pageVO);
	public LearnVO selectPrev(SearchLearnVO pageVO);
	public void delete(int no);
	public int insert(LearnVO learnVO);
	public List<DeptVO> selectLeftMenuList();
}
