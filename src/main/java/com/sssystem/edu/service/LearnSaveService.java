package com.sssystem.edu.service;

import org.springframework.transaction.annotation.Transactional;

import com.sssystem.edu.common.AttachNotInsertException;
import com.sssystem.edu.common.AuthNotInsertException;
import com.sssystem.edu.common.BoardNotInsertException;
import com.sssystem.edu.common.LearnNotInsertException;
import com.sssystem.edu.common.TestNotUpdateException;
import com.sssystem.edu.vo.AttachFileVO;
import com.sssystem.edu.vo.AuthVO;
import com.sssystem.edu.vo.BoardVO;
import com.sssystem.edu.vo.DeptVO;
import com.sssystem.edu.vo.LearnVO;

public class LearnSaveService {

	private LearnService learnService;
	private AuthService authService;
	private BoardService boardService;
	private AttachFileService attachFileService;
	private TestService testService;
	
	public LearnSaveService() {
	}
	
	public LearnSaveService(LearnService learnService, AuthService authService,
			BoardService boardService, AttachFileService attachFileService,
			TestService testService) {
		super();
		this.learnService = learnService;
		this.authService = authService;
		this.boardService = boardService;
		this.attachFileService = attachFileService;
		this.testService = testService;
	}

	@Transactional
	public	void learnSave(LearnVO learnVO
			              , DeptVO deptVO
			              , String job_str
			              , AttachFileVO attachVO){
		//1. 교육등록
		int edu_no = learnService.insert(learnVO);
		if (edu_no < 1) throw new LearnNotInsertException();
		
		//2. 권한등록
		int[] dept = deptVO.getDept();
		if (dept.length > 0) authService.delete(edu_no);
		for (int dept_no : dept){
			AuthVO authVO = new AuthVO(0, edu_no, dept_no, job_str, null);
			if (!(authService.insert(authVO))){
				throw new AuthNotInsertException();
			}
		}
		
		if (attachVO.getAttach_file() != null || attachVO.getAttach_file().equals("")) {
		//3. 자료실저장 (20)
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
		
		//4. 첨부파일저장
			attachVO.setRef_no(board_no);
			int attach_no = attachFileService.insert(attachVO);
			if (attach_no < 1){
				throw new AttachNotInsertException();
			}
		}
		
		//5. 시험등록
		if (!(testService.eduInsert(edu_no, learnVO.getUser_no()))){
			throw new TestNotUpdateException();
		}
	}
	
	@Transactional
	public	void learnUpdate(LearnVO learnVO
			               , DeptVO deptVO
			               , String job_str
			               , AttachFileVO attachVO){
		//1. 교육등록
		if (!learnService.update(learnVO)) throw new LearnNotInsertException();
		
		//2. 권한등록
		int[] dept = deptVO.getDept();
		if (dept.length > 0) authService.delete(learnVO.getEdu_no());
		for (int dept_no : dept){
			AuthVO authVO = new AuthVO(0, learnVO.getEdu_no(), dept_no, job_str, null);
			if (!(authService.insert(authVO))){
				throw new AuthNotInsertException();
			}
		}
		
		if (attachVO.getAttach_file() != null || attachVO.getAttach_file().equals("")) {
		//3. 자료실저장 (20)
			String status = "update";
			BoardVO boardVO = boardService.selectEdu(learnVO.getEdu_no());
			if (boardVO == null) status = "insert";
			boardVO.setEdu_no(learnVO.getEdu_no());
			boardVO.setUser_no(learnVO.getUser_no());
			boardVO.setBoard_gb("20");
			boardVO.setTitle(learnVO.getTitle());
			boardVO.setContents(learnVO.getContents());
			
			if (status.equals("insert")){
				int board_no = boardService.boardInsert(boardVO);
				boardVO.setBoard_no(board_no);
				if (board_no < 1){
					throw new BoardNotInsertException();
				}
			} else {
				if (!boardService.boardUpdate(boardVO)){
					throw new BoardNotInsertException();
				}
			}
		
		//4. 첨부파일저장
			attachVO.setRef_no(boardVO.getBoard_no());
			if (status.equals("insert")){
				int attach_no = attachFileService.insert(attachVO);
				if (attach_no < 1){
					throw new AttachNotInsertException();
				}
			} else {
				if (!attachFileService.update(attachVO)){
					throw new AttachNotInsertException();
				}
			}
		}
	}
}
