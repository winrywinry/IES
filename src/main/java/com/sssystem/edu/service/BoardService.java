package com.sssystem.edu.service;

import java.util.List;

import com.sssystem.edu.vo.AttachFileVO;
import com.sssystem.edu.vo.BoardVO;
import com.sssystem.edu.vo.ReplyVO;
import com.sssystem.edu.vo.search.SearchBoardVO;
import com.sssystem.edu.vo.support.SessionVO;

public interface BoardService  {
	
	/**
	 * ��������, �ڷ��, �Խ���
	 * @param bean
	 * @return
	 */
	public boolean boardInsert(BoardVO bean); // ���
	public boolean atchBoardInsert(AttachFileVO atchBean); //÷������
	public boolean boardDelete(int board_no); //����
	public boolean boardUpdate(BoardVO bean); //����
	public BoardVO boardDetailSelect(int no,int gb); //�˻�(Ư����)
	public List<BoardVO> boardListSelectAll(SearchBoardVO bean, int page); //�˻�(��ü��)
	public void upHits(int board_no); //��ȸ��
	public int selectCnt(SearchBoardVO bean); //
	
	/**
	 * ����
	 * @param board_no
	 * @return
	 */
	public List<ReplyVO> replyList(int board_no); //��ȸ
	public boolean replyUpdate(ReplyVO reply); //������Ʈ
	public boolean replyDelete(int comment_no); //����
	public boolean replyInsert(ReplyVO reply); //���
	public int selectMaxNo(); //�ִ밹��
	public ReplyVO replySelect(int comment_no);//�������� ������
	public SessionVO checkManage(int user_no);
	public List<BoardVO> notice();
	public String selectReply(int user_no);
	public List<BoardVO> replyContents(int user_no);
	

	}
