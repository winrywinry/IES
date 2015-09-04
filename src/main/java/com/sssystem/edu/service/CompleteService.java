package com.sssystem.edu.service;

import java.util.List;

import com.sssystem.edu.vo.CompleteVO;
import com.sssystem.edu.vo.LearnVO;

public interface CompleteService {
	public CompleteVO selectComplete(int edu_no, int user_no);
	public boolean updateComplete(CompleteVO completeVO);
	public boolean insertComplete(CompleteVO completeVO);
	public boolean insertFavorite(CompleteVO completeVO);
	public int selectFavorite(int edu_no, int user_no);
	public List<CompleteVO> myLearn(int user_no);
	public List<CompleteVO> myLearn2(int user_no);
	public int learnCount(int user_no);
	public int learnCount2(int user_no);
	public List<LearnVO> cal();
}
