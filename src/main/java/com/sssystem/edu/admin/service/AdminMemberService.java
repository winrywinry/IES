package com.sssystem.edu.admin.service;

import java.util.List;

import com.sssystem.edu.admin.vo.MemberVO;
import com.sssystem.edu.admin.vo.PageVO;
import com.sssystem.edu.vo.DeptVO;
import com.sssystem.edu.vo.JobVO;


public interface AdminMemberService {
  
  public List<MemberVO> selectAll(PageVO pageVO, int page);
  public int selectDuple(MemberVO member);
  public int selectTotal(PageVO pageVO);
  public List<DeptVO> selectDept();
  public List<JobVO> selectJob();
  public MemberVO insert(MemberVO member);
  public MemberVO select(int user_no);
  public boolean delete(int no);
  public boolean update(MemberVO member);
  
  
  
  
}
