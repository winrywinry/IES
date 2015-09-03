package com.sssystem.edu.service;

import java.util.List;

import com.sssystem.edu.vo.LearnVO;
import com.sssystem.edu.vo.QnaBoardVO;
import com.sssystem.edu.vo.search.SearchBoardVO;
import com.sssystem.edu.vo.AttachFileVO;

public interface QnaService {

	public boolean qnaBoardInsert(QnaBoardVO bean);//게시글 등록
	public boolean atchBoardinsert(AttachFileVO bean);//첨부파일 등록
	public boolean qnaBoardDelete(int qna_no);//게시글 삭제
	public boolean qnaBoardUpdate(QnaBoardVO bean);//게시글 업데이트
	public QnaBoardVO qnaBoardView(int qna_no, int board_gb);//게시글 보기
	public List<QnaBoardVO> qnaBoardListSelectAll(SearchBoardVO bean, int page);//게시글 목록
	public String nmSelect(int user_no);
	public void hitsUpdate(int qna_no);//조회수
	public int cntSelect(SearchBoardVO bean);//검색관련
	public void answerUpdate(QnaBoardVO bean);//답변 등록
	public String answerNmSelect(int user_no);//답변자 이름 검색
	public List<QnaBoardVO> recommendView();
	public LearnVO searchEdu(int edu_no);
}
