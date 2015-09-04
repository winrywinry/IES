package com.sssystem.edu.service;

import com.sssystem.edu.vo.AttachFileVO;

public interface AttachFileService {
	public int insert(AttachFileVO attachVO);
	public boolean update(AttachFileVO attachVO);
	public boolean deleteEdu(int edu_no);

}
