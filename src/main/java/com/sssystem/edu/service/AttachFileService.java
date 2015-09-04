package com.sssystem.edu.service;

import java.util.List;

import com.sssystem.edu.vo.AttachFileVO;

public interface AttachFileService {
	public int insert(AttachFileVO attachVO);
	public boolean update(AttachFileVO attachVO);
	public boolean deleteEdu(int edu_no);	
	public List<AttachFileVO> selectFile(int ref_no);
}
