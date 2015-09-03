package com.sssystem.edu.service.impl;

import org.apache.ibatis.session.SqlSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.sssystem.edu.service.AttachFileService;
import com.sssystem.edu.vo.AttachFileVO;

public class AttachFileServiceImpl implements AttachFileService {

	@Autowired
	SqlSession session;
	
	@Override
	public int insert(AttachFileVO attachVO) {
		session.insert("attach.insert", attachVO);
		int attach_no = attachVO.getAttach_no();
		return attach_no;
	}

	@Override
	public boolean update(AttachFileVO attachVO) {
		int t = session.update("attach.update", attachVO);
		if (t == 1) return true;
		return false;
	}

}
