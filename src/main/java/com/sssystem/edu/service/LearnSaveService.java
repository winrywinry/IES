package com.sssystem.edu.service;

import org.springframework.transaction.annotation.Transactional;

import com.sssystem.edu.common.AuthNotInsertException;
import com.sssystem.edu.common.BoardNotInsertException;
import com.sssystem.edu.common.LearnNotInsertException;
import com.sssystem.edu.common.ValidateParamChk;
import com.sssystem.edu.vo.AttachFileVO;
import com.sssystem.edu.vo.AuthVO;
import com.sssystem.edu.vo.BoardVO;
import com.sssystem.edu.vo.DeptVO;
import com.sssystem.edu.vo.LearnVO;

public class LearnSaveService {

	private LearnVO learnVO;
	private DeptVO deptVO;
	private AuthVO authVO;
	private AttachFileVO attachVO;
	private LearnService learnService;
	private AuthService authService;
	private BoardService boardService;
	private AttachFileService attachFileService;
	
	
	
	@Transactional
	public	void LearnSave(String job_str){
		ValidateParamChk chk = new ValidateParamChk();
		
		//1. �������
		int edu_no = learnService.insert(learnVO);
		if (edu_no < 1) throw new LearnNotInsertException();
		
		//2. ���ѵ��
		int[] dept = deptVO.getDept();
		if (dept.length > 0) authService.delete(edu_no);
		for (int dept_no : dept){
			AuthVO authVO = new AuthVO(0, edu_no, dept_no, job_str, null);
			if (!(authService.insert(authVO))){
				throw new AuthNotInsertException();
			}
		}
		
		if (attachVO.getAttach_file() != null || attachVO.getAttach_file().equals("")) {
		//3. �ڷ������ (20)
			BoardVO boardVO = new BoardVO();
			boardVO.setEdu_no(edu_no);
			boardVO.setUser_no(learnVO.getUser_no());
			boardVO.setBoard_gb("20");
			boardVO.setTitle(learnVO.getTitle());
			boardVO.setContents(learnVO.getContents());
			int board_no = boardService.boardInsert(boardVO);
			if (board_no < 1){
				throw new BoardNotInsertException();
			}
		
		//4. ÷����������
			attachFileService.insert(attachVO);
		}
		
		//5. ������
	}
}
