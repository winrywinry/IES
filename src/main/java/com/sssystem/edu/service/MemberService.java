package com.sssystem.edu.service;

import java.util.HashMap;
import java.util.List;

import com.sssystem.edu.vo.BoardVO;
import com.sssystem.edu.vo.MemberVO;
import com.sssystem.edu.vo.QnaBoardVO;
import com.sssystem.edu.vo.support.SessionVO;


public interface MemberService {

	public boolean updateJoin(MemberVO member);
	public String selectLogin(String id);
	public String selectEmp(String user_nm, String emp_serial);
	public String selectEmp1(String user_nm, String emp_serial);
	public boolean findId(String name, String empno);
	public SessionVO selectSession(String id);
	public HashMap<String, Object> selectDept(HashMap<String, String> map);
	public HashMap<String, Object> selectDept1(HashMap<String, String> map);
	public String selectEmp2(HashMap<String, String> map);
	public MemberVO select(int user_no);
	public MemberVO select2(int user_no);
	public int selectID(String id);
	public String selectLogSession(int log);
	public String selectWrite(int log);
	public void insertLog(int log);
	public String selectQuestion(int log);
	public List<QnaBoardVO> myWriteView(int log);
	public List<BoardVO> myQuestionView(int log);
	public String photo(int user_no);
	
}
