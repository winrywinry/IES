package com.sssystem.edu.service.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.sssystem.edu.admin.vo.PageVO;
import com.sssystem.edu.service.LearnService;
import com.sssystem.edu.vo.DeptVO;
import com.sssystem.edu.vo.LearnVO;
import com.sssystem.edu.vo.search.SearchLearnVO;

public class LearnServiceImpl implements LearnService {

	@Autowired
	SqlSession session;

	@Override
	public List<LearnVO> selectAll(SearchLearnVO pageVO, int page) {
		List<LearnVO> list = null;
		list = session.selectList("learn.selectList", pageVO, new RowBounds(
				page * 10 - 10, 10));
		return list;
	}

	@Override
	public int selectCnt(SearchLearnVO pageVO) {
		int cnt = 0;
		cnt = session.selectOne("learn.selectCnt", pageVO);
		return cnt;
	}

	@Override
	public void updateViewCnt(int no) {
		session.update("learn.updateViewCnt", no);
	}

	@Override
	public LearnVO select(int no) {
		LearnVO learnVO = null;
		learnVO = session.selectOne("learn.select", no);
		return learnVO;
	}

	@Override
	public LearnVO selectNext(SearchLearnVO pageVO) {
		LearnVO learnNext = null;
		learnNext = session.selectOne("learn.selectNext", pageVO);
		return learnNext;
	}

	@Override
	public LearnVO selectPrev(SearchLearnVO pageVO) {
		LearnVO learnPrev = null;
		learnPrev = session.selectOne("learn.selectPrev", pageVO);
		return learnPrev;
	}

	@Override
	public boolean delete(int no) {
		int t = session.delete("learn.delete", no);
		if (t>0) return true;
		return false;
		
	}

	@Override
	public List<HashMap<String, Object>> selectLeftMenuList() {
		List<HashMap<String, Object>> list = null;
		list = session.selectList("learn.selectLeftMenuList");
		return list;
	}
	
	@Override
	public int insert(LearnVO learnVO) {
		session.insert("learn.insert", learnVO);
		int edu_no = learnVO.getEdu_no();
		return edu_no;
	}

	@Override
	public boolean update(LearnVO learnVO) {
		int t = session.update("learn.update", learnVO);
		if (t == 1) return true;
		return false;
	}

}
