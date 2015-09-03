package com.sssystem.edu.service.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.sssystem.edu.vo.BoardVO;
import com.sssystem.edu.vo.MemberVO;
import com.sssystem.edu.vo.QnaBoardVO;
import com.sssystem.edu.service.MemberService;
import com.sssystem.edu.vo.support.SessionVO;

public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private SqlSession session;

	@Override
	public boolean updateJoin(MemberVO member) {//회원가입
		int t = session.update("member.join", member);
		System.out.println(t);
		if (t == 1) return true;
		return false;
	}

	@Override
	public String selectLogin(String id) {//로그인
		String pw = session.selectOne("member.login", id);
		return pw;
	}

	@Override
	public String selectEmp(String user_nm, String emp_serial) {
		String result = session.selectOne("member.selectEmp", emp_serial);
		return result;
	}//회원가입전 이름, 사원번호 확인

	@Override
	public String selectEmp1(String user_nm, String emp_serial) {
		String user_name = session.selectOne("member.selectEmp1", emp_serial);
		return user_name;
	}

	@Override
	public boolean findId(String name, String empno) {
		int t = session.selectOne("member.findId", name);
		if(t == 1) return true;
		return false;
	}//아이디 찾기

	@Override
	public SessionVO selectSession(String id) {
		SessionVO sessionVO = null;
		sessionVO = session.selectOne("member.session", id);
		return sessionVO;
	}

	@Override
	public HashMap<String, Object> selectDept(HashMap<String, String> map) {
		HashMap<String, Object> getMap = null;
		getMap = session.selectOne("member.selectDept", map);
		return getMap;
	}

	@Override
	public HashMap<String, Object> selectDept1(HashMap<String, String> map) {
		HashMap<String, Object> getMap = null;
		getMap = session.selectOne("member.selectDept1", map);
		return getMap;
	}

	@Override
	public String selectEmp2(HashMap<String, String> map) {
		String user_nm = session.selectOne("member.selectEmp2", map);
		return user_nm;
	}

	@Override
	public MemberVO select(int user_no) {
		MemberVO member = session.selectOne("member.select", user_no);
		return member;
	}

	@Override
	public MemberVO select2(int user_no) {
		return null;
	}

	@Override
	public int selectID(String id) {
		int result = session.selectOne("member.selectID", id);
		return result;
	}

	@Override
	public String selectLogSession(int log) {
		String att = null;
		att = (String) session.selectOne("member.logSession", log);
		return att;
	}

	@Override
	public String selectWrite(int log) {
		String write = null;
		write = (String) session.selectOne("member.selectWrite", log);
		return write;
	}

	@Override
	public void insertLog(int log) {
		session.insert("member.insertLog", log);
	}

	@Override
	public String selectQuestion(int log) {
		String question = null;
		question = (String) session.selectOne("member.selectQuestion", log);
		return question;
	}

	@Override
	public List<QnaBoardVO> myWriteView(int log) {
		List<QnaBoardVO> title = null;
		 title = session.selectList("member.myWriteView", log);
		return title;
	}

	@Override
	public List<BoardVO> myQuestionView(int log) {
		List<BoardVO> title = null;
		title = session.selectList("member.myQuestionView", log);
		return title;
	}

	@Override
	public String photo(int user_no) {
		String photo = null;
		photo = session.selectOne("member.photo", user_no);
		return photo;
	}

}
