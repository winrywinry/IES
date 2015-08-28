package com.sssystem.edu.service.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.sssystem.edu.service.QnaService;
import com.sssystem.edu.vo.AttachFileVO;
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
		System.out.println("implȣ��"+bean.getTitle());
		System.out.println("implȣ��"+bean.getQ_contents());
		System.out.println("implȣ��"+bean.getQna_no());
		int t = session.update("qna.qnaBoardUpdate",bean);
		System.out.println(t);
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
		System.out.println("üũ1");
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
	public int haha() {
		// TODO Auto-generated method stub
		int haha = session.selectOne("qna.hahaha");
		return haha;
	}
	
	
}
