package com.sssystem.edu.service.impl;

import java.util.List;

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

	@Override
	public List<AttachFileVO> selectFile(int ref_no) {
		List<AttachFileVO> list = session.selectList("attach.selectFile",ref_no);
		return list;
	}

	@Override
	public boolean deleteEdu(int edu_no) {
		int t = session.delete("attach.deleteEdu", edu_no);
		if (t > 0) return true;
		return false;
	}

}
