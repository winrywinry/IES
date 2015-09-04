package com.sssystem.edu.service.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.sssystem.edu.service.BoardService;
import com.sssystem.edu.vo.AttachFileVO;
import com.sssystem.edu.vo.BoardVO;
import com.sssystem.edu.vo.ReplyVO;
import com.sssystem.edu.vo.search.SearchBoardVO;
import com.sssystem.edu.vo.support.SessionVO;


public class BoardServiceImpl implements BoardService {

	@Autowired
	private SqlSession session;

	/**
	 * ��������, �����Խ���, �ڷ�� ���
	 * @param bean
	 * @return
	 */
	@Override
	public int boardInsert(BoardVO bean) {
		session.insert("notice.boardInsert", bean);
		int board_no = bean.getBoard_no();
		return board_no;
	}
	
	/**
	 * ��������, �����Խ���, �ڷ�� ÷������ ���
	 * @param bean
	 * @return
	 */
	@Override
	public boolean atchBoardInsert(AttachFileVO atchBean) {
		int t = session.insert("notice.atchBoardInsert",atchBean);
		return false;
	}

	/**
	 * ��������, �����Խ���, �ڷ�� ����
	 * @param no
	 * @return
	 */
	@Override
	public boolean boardDelete(int board_no) {
		int t = session.delete("notice.boardDelete", board_no);
		return false;
	}
	
	/**
	 * ��������, �����Խ���, �ڷ�� ����
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
	 * ��������, �����Խ���, �ڷ�� �˻�(Ư����)
	 * @param no
	 * @return
	 */
	@Override
	public BoardVO boardDetailSelect(int no, int gb) {
		BoardVO board = null;
		HashMap<String, Object> map = new HashMap<String, Object>(); 
		
		map.put("board_gb", gb);
		map.put("board_no", no);		
		
		board = session.selectOne("notice.boardDetailSelect", map);
		return board;
	}

	/**
	 * ��������, �����Խ���, �ڷ�� �˻�(��ü��)
	 * @return
	 */
	@Override
	public List<BoardVO> boardListSelectAll(SearchBoardVO bean, int page) {
		List <BoardVO> list = session.selectList("notice.boardListSelectAll", bean,new RowBounds(page*10-10,10));
		return list;
	}
	
	/**
	 * ��������, �����Խ���, �ڷ�� ��ȸ��
	 */
	@Override
	public void upHits(int board_no) {
		session.update("notice.uphits", board_no);
		
	}
	
	@Override
	public int selectCnt(SearchBoardVO bean) {
		int cnt = session.selectOne("notice.cntSelect",bean);
		return cnt;
	}
	
	/**
	 * ��������, �����Խ���, �ڷ�� ������ȸ
	 */
	@Override
	public List<ReplyVO> replyList(int board_no) {
		List<ReplyVO> list = session.selectList("notice.replyList",board_no);
		return list;
	}
	
	/**
	 * ���þ�������
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
	 * ���� ����
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
	 * �����߰�
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
		no = session.selectOne("notice.replyMaxNo");
		return no;
	}

	@Override
	public SessionVO checkManage(int user_no) {
	
		return null;
	}
	
	/**
	 * ���� ���
	 */
	public ReplyVO replySelect(int comment_no) {
		ReplyVO reply = null;
	//	reply = (ReplyVO) session.selectList("notice.replySelect",comment_no);
		reply = session.selectOne("notice.replySelect",comment_no);
		return reply;
	}

	@Override
	public List<BoardVO> notice() {
		List<BoardVO> notice = null;
		notice = session.selectList("notice.notice");
		return notice;
	}

	@Override
	public String selectReply(int user_no) {
		String reply = null;
		reply = (String) session.selectOne("notice.reply",user_no);
		return reply;
	}

	@Override
	public List<BoardVO> replyContents(int user_no) {
		List<BoardVO> list = session.selectList("notice.replyContents", user_no);
		return list;
	}

	@Override
	public String nmSelect(int user_no) {
		String nmSelect = session.selectOne("notice.nmSelect",user_no);
		return nmSelect;
	}

	@Override
	public BoardVO selectEdu(int edu_no) {
		return session.selectOne("notice.selectEdu", edu_no);
	}

	@Override
	public boolean deleteEdu(int edu_no) {
		int t = session.delete("notice.deleteEdu", edu_no);
		if (t > 0) return true; 
		return false;
	}

	

}
