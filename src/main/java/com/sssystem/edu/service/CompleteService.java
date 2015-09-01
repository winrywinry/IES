package com.sssystem.edu.service;

import com.sssystem.edu.vo.CompleteVO;

public interface CompleteService {
	public CompleteVO selectComplete(int edu_no, int user_no);
	public boolean updateComplete(CompleteVO completeVO);
	public boolean insertComplete(CompleteVO completeVO);

}
