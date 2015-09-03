package com.sssystem.edu.service;

import java.util.List;

import com.sssystem.edu.vo.LearnVO;
import com.sssystem.edu.vo.QnaBoardVO;
import com.sssystem.edu.vo.search.SearchBoardVO;
import com.sssystem.edu.vo.AttachFileVO;

public interface QnaService {

	public boolean qnaBoardInsert(QnaBoardVO bean);//�Խñ� ���
	public boolean atchBoardinsert(AttachFileVO bean);//÷������ ���
	public boolean qnaBoardDelete(int qna_no);//�Խñ� ����
	public boolean qnaBoardUpdate(QnaBoardVO bean);//�Խñ� ������Ʈ
	public QnaBoardVO qnaBoardView(int qna_no, int board_gb);//�Խñ� ����
	public List<QnaBoardVO> qnaBoardListSelectAll(SearchBoardVO bean, int page);//�Խñ� ���
	public void hitsUpdate(int qna_no);//��ȸ��
	public int cntSelect(SearchBoardVO bean);//�˻�����
	public void answerUpdate(QnaBoardVO bean);//�亯 ���
	public String answerNmSelect(int user_no);//�亯�� �̸� �˻�
	public List<QnaBoardVO> recommendView();
	public LearnVO searchEdu(int edu_no);
}
