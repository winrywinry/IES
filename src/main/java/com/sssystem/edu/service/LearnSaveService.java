package com.sssystem.edu.service;

import org.springframework.transaction.annotation.Transactional;

import com.sssystem.edu.common.LearnNotInsertException;
import com.sssystem.edu.common.ValidateParamChk;
import com.sssystem.edu.vo.AuthVO;
import com.sssystem.edu.vo.DeptVO;
import com.sssystem.edu.vo.LearnVO;

public class LearnSaveService {

	private LearnVO learnVO;
	private DeptVO deptVO;
	private AuthVO authVO;
	private LearnService learnService;
	private AuthService authService;
	
	
	
	@Transactional
	public	void LearnSave(String job_str){
		ValidateParamChk chk = new ValidateParamChk();
		
		//1. 교육등록
		int edu_no = learnService.insert(learnVO);
		if (edu_no < 1) throw new LearnNotInsertException();
		
		//2. 권한등록
		int[] dept = deptVO.getDept();
		for (int dept_no : dept){
			AuthVO authVO = new AuthVO(0, edu_no, dept_no, job_str, null);
			authService.insert(authVO);
		}
		
		//3. 자료실저장 (20)
		
		//4. 첨부파일저장
		
		//5. 시험등록
	}
}
