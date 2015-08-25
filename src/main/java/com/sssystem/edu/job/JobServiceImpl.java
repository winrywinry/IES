package com.sssystem.edu.job;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class JobServiceImpl implements JobService {

	@Autowired
	SqlSession session;
	
	@Override
	public List<JobVO> selectAll() {
		return session.selectList("job.selectAll");
	}

}
