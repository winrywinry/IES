package com.sssystem.edu.service;

import java.util.List;

import com.sssystem.edu.admin.vo.PageVO;
import com.sssystem.edu.vo.LearnVO;

public interface LearnService {
	public List<LearnVO> selectAll(PageVO pageVO, int page);
	public int selectCnt(PageVO pageVO);
}
