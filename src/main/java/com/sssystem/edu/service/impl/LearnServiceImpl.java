package com.sssystem.edu.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.sssystem.edu.admin.vo.PageVO;
import com.sssystem.edu.service.LearnService;
import com.sssystem.edu.vo.LearnVO;

public class LearnServiceImpl implements LearnService{

	@Autowired
	SqlSession session;
	
	@Override
	public List<LearnVO> selectAll(PageVO pageVO, int page) {
		List<LearnVO> list = null;
		list = session.selectList("learn.selectList",pageVO,new RowBounds(page*10-10,10));
		return list;
	}

	@Override
	public int selectCnt(PageVO pageVO) {
		int cnt = 0;
		cnt = session.selectOne("learn.selectCnt",pageVO);
		return cnt;
	}

}