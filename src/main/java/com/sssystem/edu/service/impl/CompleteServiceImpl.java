package com.sssystem.edu.service.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.sssystem.edu.service.CompleteService;
import com.sssystem.edu.vo.CompleteVO;
import com.sssystem.edu.vo.TestVO;

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
	public List<TestVO> selectTest(int edu_no) {
		List<TestVO> list = session.selectList("complete.selectTest",edu_no);
		return list;
	}

}
