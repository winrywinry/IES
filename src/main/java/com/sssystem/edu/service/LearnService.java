package com.sssystem.edu.service;

import java.util.List;

import com.sssystem.edu.admin.vo.PageVO;
import com.sssystem.edu.vo.LearnVO;

public interface LearnService {
	public List<LearnVO> selectAll(PageVO pageVO, int page);
	public int selectCnt(PageVO pageVO);
	public void updateViewCnt(int no);
	public LearnVO select(int no);
	public LearnVO selectNext(PageVO pageVO);
	public LearnVO selectPrev(PageVO pageVO);
	
}
