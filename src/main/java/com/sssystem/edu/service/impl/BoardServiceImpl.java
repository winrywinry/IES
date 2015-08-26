package com.sssystem.edu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.sssystem.edu.service.BoardService;
import com.sssystem.edu.vo.AtttachFileVO;
import com.sssystem.edu.vo.BoardVO;
import com.sssystem.edu.vo.ReplyVO;
import com.sssystem.edu.vo.search.SearchBoardVO;
import com.sssystem.edu.vo.support.SessionVO;


public class BoardServiceImpl implements BoardService {

	@Autowired
	private SqlSession session;

	/**
	 * 공지사항, 자유게시판, 자료실 등록
	 * @param bean
	 * @return
	 */
	@Override
	public boolean boardInsert(BoardVO bean) {
		int t = session.insert("notice.boardInsert", bean);
		if(t==1) {
			return true;
		}
		return false;
	}
	
	/**
	 * 공지사항, 자유게시판, 자료실 첨부파일 등록
	 * @param bean
	 * @return
	 */
	@Override
	public boolean atchBoardInsert(AtttachFileVO atchBean) {
		int t = session.insert("notice.atchBoardInsert",atchBean);
		return false;
	}

	/**
	 * 공지사항, 자유게시판, 자료실 삭제
	 * @param no
	 * @return
	 */
	@Override
	public boolean boardDelete(int board_no) {
		int t = session.delete("notice.boardDelete", board_no);
		return false;
	}
	
	/**
	 * 공지사항, 자유게시판, 자료실 수정
	 * @param bean
	 * @return
	 */
	@Override
	public boolean boardUpdate(BoardVO bean) {
		int t = session.update("notice.boardUpdate", bean);
		if(t==1) {
			return true;
		}
		return false;
	}

	/**
	 * 공지사항, 자유게시판, 자료실 검색(특정행)
	 * @param no
	 * @return
	 */
	@Override
	public BoardVO boardDetailSelect(int no, int gb) {
		BoardVO board = null;
		HashMap<String, Object> map = new HashMap<String, Object>(); 
		map.put("board_gb", gb);
		map.put("board_no", no);		
		
		return board;
	}

	/**
	 * 공지사항, 자유게시판, 자료실 검색(전체행)
	 * @return
	 */
	@Override
	public List<BoardVO> boardListSelectAll(SearchBoardVO bean, int page) {
		List <BoardVO> list = session.selectList("notice.boardListSelectAll", bean,new RowBounds(page*10-10,10));
		return list;
	}
	
	/**
	 * 공지사항, 자유게시판, 자료실 조회수
	 */
	@Override
	public void upHits(int board_no) {
		session.update("notice.uphits", board_no);
		
	}
	
	@Override
	public int selectCnt(SearchBoardVO bean) {
		int cnt = session.selectOne("qna.cntSelect",bean);
		return cnt;
	}
	
	/**
	 * 공지사항, 자유게시판, 자료실 리플조회
	 */
	@Override
	public List<ReplyVO> replyList(int board_no) {
		List<ReplyVO> list = session.selectList("notice.replyList",board_no);
		return list;
	}
	
	/**
	 * 리플업데이터
	 */
	@Override
	public boolean replyUpdate(ReplyVO reply) {
		int t = session.update("notice.replyUpdate",reply);
		if(t==1) {
			return true;
		}
		return false;
	}
	
	/**
	 * 리플 삭제
	 */
	@Override
	public boolean replyDelete(int comment_no) {
		int t = session.delete("notice.replyDelete",comment_no);
		if(t==1){
			return true;		
		}
		return false;
	}
	
	/**
	 * 리플추가
	 */
	@Override
	public boolean replyInsert(ReplyVO reply) {
		session.insert("notice.replyInsert",reply);
			return true;
	}

	/**
	 * 
	 */
	@Override
	public int selectMaxNo() {
		int no = 0;
		//no = (Integer)session.queryForObject("notice.replyMaxNo");
		return no;
	}

	@Override
	public SessionVO checkManage(int user_no) {
	
		return null;
	}
	public ReplyVO replySelect(int comment_no) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> notice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selectReply(int user_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> replyContents(int user_no) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
