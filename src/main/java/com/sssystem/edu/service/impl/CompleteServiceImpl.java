package com.sssystem.edu.service.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.sssystem.edu.service.CompleteService;
import com.sssystem.edu.vo.CompleteVO;
import com.sssystem.edu.vo.LearnVO;

public class CompleteServiceImpl implements CompleteService {
	@Autowired
	SqlSession session;

	@Override
	public CompleteVO selectComplete(int edu_no, int user_no) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("edu_no", edu_no);
		map.put("user_no", user_no);
		System.out.println("edu_no = "+edu_no);
		CompleteVO learnComplete = session.selectOne("complete.selectComplete", map);
		return learnComplete;
	}

	@Override
	public boolean updateComplete(CompleteVO completeVO) {
		int t = session.update("complete.updateComplete", completeVO);
		if (t > 0)
			return true;
		return false;
	}

	@Override
	public boolean insertComplete(CompleteVO completeVO) {
		int t = session.insert("complete.insertComplete",completeVO);
		if(t>0) return true;
		return false;
	}

	@Override
	public boolean insertFavorite(CompleteVO completeVO) {
		int t = session.insert("complete.insertFavorite",completeVO);
		if(t>0) return true;
		return false;
	}

	@Override
	public int selectFavorite(int edu_no,int user_no) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("edu_no",edu_no);
		map.put("user_no",user_no);
		int cntFavo = session.selectOne("complete.selectFavorite",map);
		return cntFavo;
	}

	@Override
	public List<CompleteVO> myLearn(int user_no) {
		List<CompleteVO> list = session.selectList("complete.learnTest", user_no);
		return list;
	}

	@Override
	public List<CompleteVO> myLearn2(int user_no) {
		List<CompleteVO> list = session.selectList("complete.learnTest2", user_no);
		return list;
	}
	
	@Override
	public int learnCount2(int user_no) {
		int t = session.selectOne("complete.learnCount", user_no);
		return t;
	}
	
	@Override
	public int learnCount(int user_no) {
		int t = session.selectOne("complete.learnCount2", user_no);
		System.out.println(t);
		return t;
	}

	@Override
	public List<LearnVO> cal() {
		List<LearnVO> list = session.selectList("complete.cal");
		return list;
	}

}
