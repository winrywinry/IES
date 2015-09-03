package com.sssystem.edu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.sssystem.edu.service.QnaService;
import com.sssystem.edu.vo.AttachFileVO;
import com.sssystem.edu.vo.LearnVO;
import com.sssystem.edu.vo.QnaBoardVO;
import com.sssystem.edu.vo.search.SearchBoardVO;

public class QnaServiceImpl implements QnaService {

	@Autowired
	SqlSession session;
	
	@Override
	public boolean qnaBoardInsert(QnaBoardVO bean) {//�Խñ� ���
		int t = session.insert("qna.qnaBoardInsert",bean);
		if(t==1)return true;
		return false;
	}

	@Override
	public boolean atchBoardinsert(AttachFileVO bean) {//���ϵ��, ���� �����Ǿ����� ����
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean qnaBoardDelete(int qna_no) {//�Խñ� ����
		int t = session.delete("qna.qnaBoardDelete",qna_no);
		if(t==1)return true;
		return false;
	}

	@Override
	public boolean qnaBoardUpdate(QnaBoardVO bean) {//�Խñ� ������Ʈ
		int t = session.update("qna.qnaBoardUpdate",bean);
		if(t>0)return true;
		return false;
	}

	@Override
	public QnaBoardVO qnaBoardView(int qna_no, int board_gb) {//�Խñ� ����
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("board_gb",board_gb);
		map.put("qna_no",qna_no);
		return session.selectOne("qna.qnaBoardView",map);
	}

	@Override
	public List<QnaBoardVO> qnaBoardListSelectAll(SearchBoardVO bean, int page) {//�Խñ� ���
		List<QnaBoardVO> list = session.selectList("qna.qnaBoardListSelectAll",bean,new RowBounds(page*10-10,10));
		return list;
	}

	@Override
	public void hitsUpdate(int qna_no) {//��ȸ��
		session.update("qna.hitsUpdate",qna_no);
	}

	@Override
	public int cntSelect(SearchBoardVO bean) {//�˻�����
		int cnt = session.selectOne("qna.cntSelect",bean);
		return cnt;
	}

	@Override
	public void answerUpdate(QnaBoardVO bean) {//�亯 ���
		session.update("qna.answerUpdate",bean);
	}

	@Override
	public String answerNmSelect(int user_no) {//�亯�� �̸� �˻�
		String anm = session.selectOne("qna.answerNmSelect",user_no);
		return anm;
	}

	@Override
	public List<QnaBoardVO> recommendView() {
		List<QnaBoardVO> title = null;
		title = session.selectList("qna.recommendView");
		return title;
	}

	@Override
	public LearnVO searchEdu(int edu_no) {
		LearnVO learnVO = session.selectOne("qna.selectTitle",edu_no);
		return learnVO;
	}

	
}
