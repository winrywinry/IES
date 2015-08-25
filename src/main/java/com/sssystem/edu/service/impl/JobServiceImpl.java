package com.sssystem.edu.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.sssystem.edu.service.JobService;
import com.sssystem.edu.vo.JobVO;

public class JobServiceImpl implements JobService {

	@Autowired
	SqlSession session;
	
	@Override
	public List<JobVO> selectAll() {
		return session.selectList("job.selectAll");
	}

}
